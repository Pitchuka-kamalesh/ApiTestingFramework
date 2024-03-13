package com.api;

import com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class GetRequests {
    public String baseURI = "https://fakestoreapi.com/";
    public RequestSpecification httpRequest;
    public Response response;
    public ResponseBody body;
    public JsonPath jsonPath;
    public JsonObject requestPrams;
    public int id;
    public static Properties properties;

    @Test
    public void get_Products_api() {

        RestAssured.baseURI = baseURI;
        httpRequest = RestAssured.given();
        response = httpRequest.get("products");
        body = response.getBody();
        jsonPath = response.jsonPath();
        System.out.println(jsonPath.getJsonObject("[0]").toString());
        System.out.println(response.getHeaders().toString());
    }

    @Test
    public void post_Product() {

        RestAssured.baseURI = baseURI;
        RequestSpecification httpRequest = RestAssured.given();


        JsonObject requestPrams = new JsonObject();
        requestPrams.addProperty("title", "test product");
        requestPrams.addProperty("price", "13.5");
        requestPrams.addProperty("description", "lorem ipsum set");
        requestPrams.addProperty(" image", "https://i.pravatar.cc");
        requestPrams.addProperty("category", "electronic");
        httpRequest.body(requestPrams);

        response = httpRequest.post("products");


        body = response.getBody();
        jsonPath = response.jsonPath();
        System.out.println(response.getStatusCode());
        System.out.println(response.getStatusLine());
        body.prettyPrint();
        System.out.println(jsonPath.getJsonObject("id").toString());
        id = jsonPath.getJsonObject("id");


    }

    @Test
    public void get_Products_api_id() {
        int id = 1;

        RestAssured.baseURI = baseURI;
        httpRequest = RestAssured.given();
        response = httpRequest.get("products/" + id);
        body = response.getBody();
        jsonPath = response.jsonPath();
        String title = jsonPath.getString("title");
        System.out.println(title);
    }

    @Test
    public void authentication_For_Token() {
        properties = new Properties();
        try(FileInputStream fi = new FileInputStream("configuration/configuration.properties")) {
            properties.load(fi);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        RestAssured.baseURI = "https://dummyjson.com/auth/";
        httpRequest = RestAssured.given();

        httpRequest.header("Content-Type","application/json");

        JsonObject requestPrams = new JsonObject();
        requestPrams.addProperty("username", "kminchelle");
        requestPrams.addProperty("password", "0lelplR");
        httpRequest.body(requestPrams);

        httpRequest.log().all();
        response = httpRequest.post("login");
        body = response.getBody();
        jsonPath = response.jsonPath();
        System.out.println(jsonPath.getString("token"));
        properties.setProperty("token",jsonPath.getString("token"));

        try {
            FileOutputStream out = new FileOutputStream("configuration/configuration.properties");
            properties.store(out,"store the token");
            out.close();
            System.out.println("Property file is updated");

        }catch (Throwable ignored){

        }

    }

    @Test
    public void authValidate(){
        loadProperties();
        RestAssured.baseURI = "https://dummyjson.com/auth/";
        httpRequest = RestAssured.given();
        httpRequest.header("Authorization",properties.getProperty("token_type")+" "+properties.getProperty("token"));
        httpRequest.log().all();
        response = httpRequest.get("me");
        body = response.getBody();
        jsonPath = response.jsonPath();
        body.prettyPrint();


    }

    public void loadProperties(){
        properties = new Properties();
        try {
            properties.load(new FileInputStream("configuration/configuration.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
