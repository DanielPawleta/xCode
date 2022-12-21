package com.example.xCode;

import jakarta.validation.constraints.Pattern;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;

@Setter
public class NumbersPostRequest {
    @Pattern(regexp = "ASC|DESC", message = "Please type ASC or DESC")
    private String order;

    private ArrayList<Integer> numbers;
    public ArrayList<Integer> getNumbers() {
        if (numbers==null) return null;
        numbers.sort(null);
        if (order.equals("DESC")) Collections.reverse(numbers);
        return numbers;
    }
}
