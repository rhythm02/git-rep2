package com.assignment.hotel.model;

import com.assignment.hotel.model.Customer;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Request {
    Customer customerType;
    List<String> listDates = new ArrayList<String>();

    public Request(Customer customerType, List<String> dates){
        this.customerType = customerType;
        this.listDates = dates;
    }
}