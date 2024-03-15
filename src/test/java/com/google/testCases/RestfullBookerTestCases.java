package com.google.testCases;

import com.google.gson.Gson;
import com.google.listners.ExtentsListeners;
import io.restassured.response.Response;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utills.RestUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.google.rcsApi.GetRequests.writeProperty;


@Listeners(ExtentsListeners.class)
public class RestfullBookerTestCases {

    @Test
    public void getAllData(){
        String url = "https://restful-booker.herokuapp.com/booking";
        Map<String,Object>requestPlayLoad = new HashMap<>();
        Response response = RestUtils.performGet(url,requestPlayLoad,new HashMap<>());
        RestUtils.printResponseLogInReport(response);
    }

    @Test
    public void getRequestById(){
        int i = 1;
        String url = "https://restful-booker.herokuapp.com/booking/";
        Map<String,Object> requestPlayLoad = new HashMap<>();
        Response response = RestUtils.performGetId(i,url,requestPlayLoad,new HashMap<>());
        RestUtils.printResponseLogInReport(response);
    }
    @Test
    public void postAuthentication() throws IOException {
        String url = "https://restful-booker.herokuapp.com/auth";
        Map<String,Object> requestPlayLoad = new HashMap<>();
        requestPlayLoad.put("username","admin");
        requestPlayLoad.put("password","password123");
        Response response = RestUtils.performPost(url,requestPlayLoad,new HashMap<>());
        RestUtils.printResponseLogInReport(response);
        writeProperty("token",response.jsonPath().getString("token"));

    }
}
