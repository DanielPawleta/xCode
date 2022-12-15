package com.example.xCode;

import java.math.BigDecimal;
import java.util.ArrayList;

public class NumbersPostResponse {
    private ArrayList<BigDecimal> numbers;

    public void setNumbers(ArrayList<BigDecimal> numbers) {
        this.numbers = numbers;
    }

    public NumbersPostResponse() {
        System.out.println("elo2");
    }

    public ArrayList<BigDecimal> getNumbers() {
        return numbers;
    }
}
