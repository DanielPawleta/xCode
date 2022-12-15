package com.example.xCode;

import jakarta.validation.constraints.Pattern;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;

public class CurrencyPostRequest {


    @Pattern(regexp = "[A-Z]{3}", message = "Please type 3-character currency code using only upper case letters")
    private String currencyName;

    public CurrencyPostRequest() {
        System.out.println("No-argument constructor in currency request");
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }
}
