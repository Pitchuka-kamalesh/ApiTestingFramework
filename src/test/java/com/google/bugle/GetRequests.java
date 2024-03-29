package com.google.bugle;

import com.google.gson.Gson;
import com.google.listners.ExtentsListeners;
import com.google.gson.JsonObject;
import com.google.pojo.Booking;
import com.google.pojo.BookingDates;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utills.ExtentReportManagerTest;
import utills.RestUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Properties;

import static utills.ExtentReportManagerTest.printRequestLogInReport;
import static utills.ExtentReportManagerTest.printResponseLogInReport;

@Listeners(ExtentsListeners.class)
public class GetRequests {
    public String baseURI = "https://restful-booker.herokuapp.com/";
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
        response = httpRequest.get("booking");
        printRequestLogInReport(httpRequest);
        body = response.getBody();
        jsonPath = response.jsonPath();
        printResponseLogInReport(response);
        System.out.println(jsonPath.getJsonObject("[0]").toString());
        System.out.println(response.getHeaders().toString());
    }

    @Test
    public void post_Product() {

        RequestSpecification httpRequest = RestAssured.given();

        BookingDates bookingDates = new BookingDates("2024-05-05","2024-05-07");
        Booking booking = new Booking("kamal","pitchuka",1000,true,bookingDates,"Big bowl");

        Gson gson = new Gson();
        String requestBody = gson.toJson(booking);

        httpRequest.body(requestBody);
        printRequestLogInReport(httpRequest);
        response = httpRequest.post("https://restful-booker.herokuapp.com/booking");
        printResponseLogInReport(response);


        body = response.getBody();
        jsonPath = response.jsonPath();
        System.out.println(response.getStatusCode());
        System.out.println(response.getStatusLine());
        body.prettyPrint();


    }

    @Test
    public void get_Products_api_id() {
        int id = 1;

        RestAssured.baseURI = baseURI;
        httpRequest = RestAssured.given();
        httpRequest.pathParam("id",id);
        response = httpRequest.get("products/{id}" );
        body = response.getBody();
        jsonPath = response.jsonPath();
        body.prettyPrint();
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

    public static void loadProperties(){
        properties = new Properties();
        try {
            properties.load(new FileInputStream("configuration/configuration.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void writeProperty(String key,String value) throws IOException {

        Properties properties = new Properties();
        properties.load(new FileInputStream("configuration/configuration.properties"));
        properties.setProperty(key, value);
        try(FileOutputStream outputStream = new FileOutputStream("configuration/configuration.properties")){
            properties.store(outputStream,"Enter the api token value");
        }catch (Throwable e){
            e.printStackTrace();
        }


    }

}
