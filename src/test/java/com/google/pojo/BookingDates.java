package com.google.pojo;

public class BookingDates {


    private String checkin;
    private  String checkout;

    public BookingDates(){

    }


    public BookingDates(String checkin,String checkout){

        setCheckin(checkin);
        setCheckout(checkout);
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }

    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }
}
