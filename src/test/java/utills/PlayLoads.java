package utills;

import java.util.HashMap;
import java.util.Map;

public class PlayLoads {

    public static Map<String,Object> getCreateHotelBookingFromMap(String firstname,String lastname,int totalprice,boolean depositpaid,String checkin,String checkout,String additionalneeds){
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

}
