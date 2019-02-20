package com.assignment.hotel.service;

import com.assignment.hotel.model.*;
import com.assignment.hotel.utility.DateToDay;

import java.util.*;

public class HotelBooking implements HotelService {

    private HotelList hotelList;
    Map<Hotel, Integer> rateCard = new HashMap<>();

    public Hotel findCheapestHotel(Request request,HotelList hotelList) {
         for (int i = 0; i < hotelList.getHotels().size(); i++) {
            int cost=0;
            int totalCost=0;
            Map<Category,Integer> map = hotelList.getHotels().get(i).getMap();

            for (int j = 0; j < request.getListDates().size(); j++) {
                int day = new DateToDay().getDay(request.getListDates().get(j));
                if(day >= Calendar.MONDAY && day <= Calendar.FRIDAY){
                    if(request.getCustomerType().equals(Customer.REGULAR)) {
                        cost = map.get(new Category(Customer.REGULAR, Days.WEEKDAY));
                    }
                    else {
                        cost = map.get(new Category(Customer.REWARD, Days.WEEKDAY));
                    }
                }
                else{
                    if(request.getCustomerType().equals(Customer.REGULAR)) {
                        cost = map.get(new Category(Customer.REGULAR, Days.WEEKEND));
                    }
                    else {
                        cost = map.get(new Category(Customer.REWARD, Days.WEEKEND));
                    }
                }
                totalCost = totalCost+cost;

            }
            rateCard.put(hotelList.getHotels().get(i), totalCost);
        }
        System.out.println("ratecard : " + rateCard);

        return minCost(rateCard);
    }

    public Hotel minCost(Map<Hotel, Integer> rateCard) {
        int min = Integer.MAX_VALUE;
        Hotel hotelObj = null;
        for (HashMap.Entry<Hotel, Integer> entry : rateCard.entrySet()){
            if(min > entry.getValue() ){
                min = entry.getValue();
                hotelObj = entry.getKey();
            }
            if(min == entry.getValue()){
                int ratingEntry = entry.getKey().getRating();
                System.out.println("ratingEntry" + ratingEntry);
                int ratingName = hotelObj.getRating();
                System.out.println("ratingName" + ratingName);

                if(ratingEntry > ratingName){
                    hotelObj = entry.getKey();
                }
            }
        }
        return hotelObj;

    }
}



