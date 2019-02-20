package com.assignment.hotel;

import com.assignment.hotel.model.*;
import com.assignment.hotel.service.HotelBooking;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class HotelBookingTest {

    private Request request;
    private static HotelList hotelList;

    @BeforeClass
    public static void init(){
        hotelList = new HotelList();
        hotelList.init();
    }

    @Test
    public void testFindCheapestHotel(){

        List<String> dates = new ArrayList<String>();
        dates.add("01/16/2019");
        dates.add("01/17/2019");
        dates.add("01/19/2019");
        dates.add("02/20/2019");

        request = new Request(Customer.REGULAR, dates);

        HotelBooking booking = new HotelBooking();
        Hotel hotel= booking.findCheapestHotel(request,hotelList);

        System.out.println(hotel.getName());
    }

    @Test
    public void testFindCheapestHotel2(){

        List<String> dates = new ArrayList<String>();
        dates.add("02/15/2019");
        dates.add("02/16/2019");
        dates.add("02/17/2019");

        request = new Request(Customer.REWARD, dates);

        HotelBooking booking = new HotelBooking();
        Hotel hotel= booking.findCheapestHotel(request,hotelList);

        System.out.println(hotel.getName());
    }

}