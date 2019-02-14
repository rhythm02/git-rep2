package com.assignment.hotel.hotel_problem;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Map;

@Getter
@AllArgsConstructor
public class Hotel {
    private String name;
    private int rating;
    private Map<Category,Integer> map;

}
