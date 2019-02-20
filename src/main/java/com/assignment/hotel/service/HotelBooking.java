package com.assignment.hotel.service;

import com.assignment.hotel.model.*;
import com.assignment.hotel.utility.DateToDay;

import java.util.*;

public class HotelBooking implements HotelService {

    private HotelList hotelList;
    private Map<Hotel, Integer> rateCard = new HashMap<>();

    public Hotel findCheapestHotel(Request request,HotelList hotelList) {
        for (Hotel hotel:hotelList.getHotels()) {
            int totalCost = hotelList.findTotalCost(hotel, request);
            rateCard.put(hotel, totalCost);
        }
        System.out.println(rateCard);
        return minCost(rateCard);
    }

    public Hotel minCost(Map<Hotel, Integer> rateCard) {
        int min = Integer.MAX_VALUE;
        Hotel hotelObj = null;

        for (HashMap.Entry<Hotel, Integer> entry : rateCard.entrySet()){
            if(min > entry.getValue()
                    || ((min == entry.getValue()) && (entry.getKey().getRating() > hotelObj.getRating())))
            {
                min = entry.getValue();
                hotelObj = entry.getKey();
            }
        }
        return hotelObj;
    }
}



