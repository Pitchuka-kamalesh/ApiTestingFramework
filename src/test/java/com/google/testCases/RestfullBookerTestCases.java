package com.google.testCases;

import com.google.gson.Gson;
import com.google.listners.ExtentsListeners;
import com.google.pojo.ResponseBookingDetails;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utills.RestUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.google.bugle.GetRequests.*;
import static com.google.payLoad.PlayLoads.createNullPlayLoad;
import static com.google.payLoad.PlayLoads.creteHotelBooking;
import static utills.ExtentReportManagerTest.printResponseLogInReport;



@Listeners(ExtentsListeners.class)
public class RestfullBookerTestCases {

    public static Gson gson = new Gson();

    @BeforeTest
    public void loadData(){
        loadProperties();
    }

    @Test
    public void getAllData(){
        String url = "https://restful-booker.herokuapp.com/booking";
        Response response = RestUtils.performGet(url,createNullPlayLoad(),new HashMap<>());
        printResponseLogInReport(response);
    }

    @Test
    public void getRequestById(int id){
        int i = 1;
        String url = "https://restful-booker.herokuapp.com/booking/";
        Response response = RestUtils.performGetId(id,url,createNullPlayLoad(),new HashMap<>());
       printResponseLogInReport(response);
        System.out.println(response.getBody().prettyPrint());
    }
    @Test
    public void postAuthentication() throws IOException {
        String url = "https://restful-booker.herokuapp.com/auth";
        Map<String,Object> requestPlayLoad = new HashMap<>();
        requestPlayLoad.put("username","admin");
        requestPlayLoad.put("password","password123");
        Response response = RestUtils.performPost(url,
                requestPlayLoad.toString(),
                new HashMap<>());
        printResponseLogInReport(response);
        writeProperty("token",response.jsonPath().getString("token"));

    }

    @Test
    public void post_Api_Booking(){
        String url = "https://restful-booker.herokuapp.com/booking";
        Map<String,String> headers = new HashMap<>();
        headers.put("content-type","application/json");
        System.out.println(headers);
        String payload = creteHotelBooking("kamal","pitchuka",1000,true,"2022-05-22","2022-05-22","Big bowl");
        Response response = RestUtils.performPost(url,payload,headers);
        printResponseLogInReport(response);
        Assert.assertEquals(response.getStatusCode(),200);
        ResponseBookingDetails responceBooking = gson.fromJson(response.asString(), ResponseBookingDetails.class);
        System.out.println(response.body().jsonPath().getInt("bookingid"));
        getRequestById(responceBooking.getBookingid());

    }
}
