package com.example.xCode;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Pattern;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;

@Setter
public class NumbersPostRequest {
    @Pattern(regexp = "ASC|DESC", message = "Please type ASC or DESC")
    private String order;

    private ArrayList<@Digits(integer = 100, fraction = 0, message = "Only integers please") BigDecimal> numbers;
    //private ArrayList<@Pattern(regexp = "^-?[0-9]*$", message = "Only integers please") BigDecimal> numbers;
    public ArrayList<BigDecimal> getNumbers() {
        if (numbers==null) return null;
        numbers.sort(null);
        if (order.equals("DESC")) Collections.reverse(numbers);
        return numbers;
    }
}
