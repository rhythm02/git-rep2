package com.assignment.hotel.hotel_problem;

import java.util.*;

public class HotelBooking implements HotelService {

    private List<Hotel> hotelList;

    HotelBooking(List<Hotel> hotelList) {
        this.hotelList = hotelList;
    }

    public Hotel findCheapestHotel(Request request) {


        ArrayList<Integer> al = new ArrayList<Integer>();

        for (int i = 0; i < hotelList.size(); i++) {
            int cost=0;
            int totalCost=0;
            Map<Category,Integer> map = hotelList.get(i).getMap();

            for (int j = 0; j < request.listDates.size(); j++) {

                int day = getDay(request.listDates.get(i));

                if(day >= Calendar.MONDAY && day <= Calendar.SUNDAY){
                    if(request.customerType.equals(Customer.REGULAR))
                        cost = map.get(new Category(Customer.REGULAR,Days.WEEKDAY));
                    else
                        cost = map.get(new Category(Customer.REWARD,Days.WEEKDAY));
                }
                else{
                    if(request.customerType.equals(Customer.REGULAR))
                        cost = map.get(new Category(Customer.REGULAR,Days.WEEKEND));
                    else
                        cost = map.get(new Category(Customer.REWARD,Days.WEEKEND));

                }
                totalCost = totalCost+cost;
                al.add(totalCost);
            }
        }
        return minCost(al);

    }

    public int getDay(String date){
        Calendar c = Calendar.getInstance();
        Date d = null;
        try {
            d = new Date(date);
        } catch (Exception e) {
            e.printStackTrace();
        }

        c.setTime(d);

        return c.get(Calendar.DAY_OF_WEEK);
    }

    public Hotel minCost(ArrayList<Integer> al){
        int min = al.get(0);
        int index = 0;
        for(int i=0; i<al.size(); i++){
            if(min > al.get(i)){
                min = al.get(i);
                index = i;
            }

            if(min == al.get(i)){
                if(hotelList.get(index).getRating() > hotelList.get(i).getRating()) {
                    min = al.get(i);
                    index = i;
                }
                else
                    min = al.get(index);
            }

        }
        return hotelList.get(index);
    }

}


