package com.google.rcsApi;

import io.restassured.response.Response;
import utills.RestUtils;

import java.util.Map;

public class PutRequest {
    public Response updateTheBookingDetails(int id,String endpoint, String requestPlayLoad, Map<String,String> headers){

        RestUtils.performPut(id,endpoint,requestPlayLoad,headers);
    return null;
    }

}
