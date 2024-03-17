package com.google.pojo;

public class ResponseBookingDetails {
    private int bookingid;
    private Booking booking;

    public ResponseBookingDetails(){

    }
    public ResponseBookingDetails(int bookingid,Booking booking){
        setBookingid(bookingid);
        setBooking(booking);
    }

    public int getBookingid() {
        return bookingid;
    }

    public void setBookingid(int bookingid) {
        this.bookingid = bookingid;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

}
