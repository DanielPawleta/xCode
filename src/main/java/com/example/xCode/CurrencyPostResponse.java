package com.example.xCode;

public class CurrencyPostResponse {
    private Float currencyValue;

    public void setCurrencyValue(String currencyName) {
        System.out.println("currency response set currency value method");




        this.currencyValue = 4.7f;
    }



    public Float getCurrencyValue() {
        return currencyValue;
    }

    public CurrencyPostResponse() {
        System.out.println("currency response created");
    }


}
