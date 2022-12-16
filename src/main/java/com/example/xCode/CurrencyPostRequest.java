package com.example.xCode;

import jakarta.validation.constraints.Pattern;
import lombok.Getter;

@Getter
public class CurrencyPostRequest {
    @Pattern(regexp = "[A-Z]{3}", message = "Please type 3-character currency code using only upper case letters")
    private String currency;
}
