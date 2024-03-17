package com.google.rcsApi;

import com.google.gson.Gson;
import com.google.pojo.Booking;
import com.google.pojo.BookingDates;
import org.testng.annotations.Test;

import java.time.LocalDate;

public class PostRequest {

    public static void main(String[] args) {
        BookingDates bookingdates = new BookingDates("2022-05-20","2022-05-22");
        Booking booking = new Booking("kamal","pitchuka",1000,true,bookingdates,"Big bowl");

        Gson gson = new Gson();
        String reguest = gson.toJson(booking);
        System.out.println(reguest);

    }

}
