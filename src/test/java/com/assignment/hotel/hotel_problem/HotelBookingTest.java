package com.assignment.hotel.hotel_problem;

import com.assignment.hotel.hotel_problem.*;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;


public class HotelBookingTest {

    private static List<Hotel> hotelList;
    private Request request;


    @BeforeClass
    public static void init(){

        Hotel lakewood;
        Hotel bridgewood;
        Hotel ridgewood;

        Map<Category, Integer> mapLakewood = new HashMap<Category, Integer>();
        mapLakewood.put(new Category(Customer.REGULAR, Days.WEEKDAY), 110);
        mapLakewood.put(new Category(Customer.REGULAR, Days.WEEKEND), 90);
        mapLakewood.put(new Category(Customer.REWARD, Days.WEEKDAY), 80);
        mapLakewood.put(new Category(Customer.REWARD, Days.WEEKEND), 80);

        Map<Category, Integer> mapBridgewood = new HashMap<Category, Integer>();
        mapBridgewood.put(new Category(Customer.REGULAR, Days.WEEKDAY), 160);
        mapBridgewood.put(new Category(Customer.REGULAR, Days.WEEKEND), 60);
        mapBridgewood.put(new Category(Customer.REWARD, Days.WEEKDAY), 110);
        mapBridgewood.put(new Category(Customer.REWARD, Days.WEEKEND), 50);


        Map<Category, Integer> mapRidgewood = new HashMap<Category, Integer>();
        mapRidgewood.put(new Category(Customer.REGULAR, Days.WEEKDAY), 220);
        mapRidgewood.put(new Category(Customer.REGULAR, Days.WEEKEND), 150);
        mapRidgewood.put(new Category(Customer.REWARD, Days.WEEKDAY), 100);
        mapRidgewood.put(new Category(Customer.REWARD, Days.WEEKEND), 40);

        lakewood = new Hotel("Lakewood", 3, mapLakewood);
        bridgewood = new Hotel("Bridgewood", 4, mapBridgewood);
        ridgewood = new Hotel("Ridgewood", 4, mapBridgewood);

        hotelList = new ArrayList<Hotel>();
        hotelList.add(lakewood);
        hotelList.add(bridgewood);
        hotelList.add(ridgewood);
    }

    @Test
    public void testFindCheapestHotel(){

        List<String> dates = new ArrayList<String>();
        dates.add("02/15/2019");
        dates.add("02/16/2019");
        dates.add("02/17/2019");
        dates.add("02/18/2019");
        request = new Request(Customer.REGULAR, dates);

        HotelBooking booking = new HotelBooking(hotelList);
        Hotel hotel= booking.findCheapestHotel(request);
        assertEquals("Bridgewood",hotel.getName());


    }

}