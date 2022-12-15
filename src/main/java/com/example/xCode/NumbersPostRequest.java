package com.example.xCode;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Pattern;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;

public class NumbersPostRequest {

    private ArrayList<@Digits(integer = 100, fraction = 0, message = "Only integers please") BigDecimal> numbers;
    //private ArrayList<@Pattern(regexp = "^[0-9]*$", message = "Only integers please") BigDecimal> numbers;

    @Pattern(regexp = "ASC|DESC", message = "Please type ASC or DESC")
    private String order;

    public NumbersPostRequest() {
        System.out.println("No-argument constructor in request");
    }

    public String getOrder() {
        System.out.println("get order in request");
        return order;
    }

    public ArrayList<BigDecimal> getNumbers() {
        if (numbers==null) return null;
        numbers.sort(null);
        if (order.equals("DESC")) Collections.reverse(numbers);
        return numbers;
    }

    public void setNumbers(ArrayList<BigDecimal> numbers) {
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
