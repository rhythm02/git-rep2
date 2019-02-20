package com.assignment.hotel.model;

import com.assignment.hotel.model.Category;
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
