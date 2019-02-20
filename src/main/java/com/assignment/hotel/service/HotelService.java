package com.assignment.hotel.service;

import com.assignment.hotel.model.Hotel;
import com.assignment.hotel.model.HotelList;
import com.assignment.hotel.model.Request;

public interface HotelService{
    Hotel findCheapestHotel(Request request, HotelList hotelList);
}
