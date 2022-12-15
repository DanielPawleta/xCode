package com.example.xCode;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;

import java.util.ArrayList;
import java.util.Collections;

public class PostRequest {
    
    private ArrayList<@Digits(integer = 2, fraction = 0, message = "only digits please")Integer> numbers;

    @Pattern(regexp = "ASC|DESC", message = "zly pattern")
    private String order;

    public PostRequest() {
        System.out.println("No-argument constructor in request");
    }

    public String getOrder() {
        System.out.println("get order in request");
        return order;
    }

    public ArrayList<Integer> getNumbers() {
        if (numbers==null) return null;
        numbers.sort(null);
        if (order.equals("DESC")) Collections.reverse(numbers);
        return numbers;
    }

    public void setNumbers(ArrayList<Integer> numbers) {
        System.out.println("number setter");
        if (numbers==null) System.out.println("numbers null");
        this.numbers = numbers;
    }

    public void setOrder(String order) {
        System.out.println("order setter");
        if (!order.equals("ASC") && (!order.equals("DESC"))) System.out.println("inny string niz ASC i DESC");
        this.order = order;
    }
}
