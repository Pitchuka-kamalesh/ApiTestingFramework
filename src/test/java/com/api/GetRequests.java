package com.api;

import com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class GetRequests {
    public String baseURI ="https://fakestoreapi.com/";
    public RequestSpecification httpRequest;
    public Response response;
    public ResponseBody body;
    public JsonPath jsonPath;
    public JsonObject requestPrams;
    public  int id;

    @Test
    public void get_Products_api(){

        RestAssured.baseURI = baseURI;
        httpRequest = RestAssured.given();
        response = httpRequest.get("products");
        body = response.getBody();
        jsonPath = response.jsonPath();
        System.out.println(jsonPath.getJsonObject("[0]").toString());
        System.out.println(response.getHeaders().toString());
    }
    @Test
    public void post_Product(){

        RestAssured.baseURI = baseURI;
        RequestSpecification httpRequest = RestAssured.given();

        JsonObject requestPrams = new JsonObject();
        requestPrams.addProperty("title","test product");
        requestPrams.addProperty("price","13.5");
        requestPrams.addProperty("description","lorem ipsum set");
        requestPrams.addProperty(" image","https://i.pravatar.cc");
        requestPrams.addProperty("category","electronic");
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
    public void get_Products_api_id(){
        int id = 1;

        RestAssured.baseURI = baseURI;
        httpRequest = RestAssured.given();
        response = httpRequest.get("products/"+id);
        body = response.getBody();
        jsonPath = response.jsonPath();
        String title = jsonPath.getString("title");
        System.out.println(title);

//        System.out.println(response.getHeaders().toString());
//        System.out.println("<----------------              --------------->");
//        System.out.println(response.getStatusLine());
//        System.out.println(body.prettyPrint());
    }

}
