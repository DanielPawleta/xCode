package com.example.xCode;

import java.util.ArrayList;
import java.util.Collections;

public class PostRequest {
    private ArrayList<Integer> numbers;
    private String order;

    public String getOrder() {
        System.out.println("elo3");
        System.out.println(order);
        return order;
    }

    public ArrayList<Integer> getNumbers() {
        numbers.sort(null);
        if (order.equals("DESC")) Collections.reverse(numbers);
        return numbers;
    }

    public void setNumbers(ArrayList<Integer> numbers) {
        System.out.println("number setter");
        this.numbers = numbers;
    }
}
