package com.google.payLoad;

import com.google.gson.Gson;
import com.google.pojo.Booking;
import com.google.pojo.BookingDates;

import java.util.HashMap;
import java.util.Map;

public class PlayLoads {
    public static Gson gson = new Gson();

    public static Map<String,Object> CreateHotelBookingFromMap(String firstname,String lastname,int totalprice,boolean depositpaid,String checkin,String checkout,String additionalneeds){
        Map<String,Object> bookingDates = new HashMap<>();
        bookingDates.put("checkin",checkin);
        bookingDates.put("checkout",checkout);
        Map<String, Object> payload = new HashMap<>();
        payload.put("firstname",firstname);
        payload.put("lastname",lastname);
        payload.put("totalprice",totalprice);
        payload.put("depositpaid",depositpaid);
        payload.put("bookingdates",bookingDates);
        payload.put("additionalneeds",additionalneeds);
        return payload;
    }

    public static  String creteHotelBooking(String firstname,String lastname,int totalprice,boolean depositpaid,String checkin,String checkout,String additionalneeds){
        BookingDates bookingdates = new BookingDates(checkin,checkout);
        Booking booking = new Booking(firstname,lastname,totalprice,depositpaid,bookingdates,additionalneeds);
        String payload = gson.toJson(booking);
        return payload;
    }
    public static String createNullPlayLoad(){
        String payload = new HashMap<String,Object>().toString();

        return payload;
    }

}
