package com.example.xCode;

import lombok.Getter;

@Getter
public class CurrencyPostResponse {
    private Float value;

    public void setValue(String value) {
        this.value = Float.valueOf(value);
    }
}
