package com.example.xCode;

import lombok.Getter;

import java.util.List;

@Getter
public class CurrencyNBPResponse {
    private String table;
    private String currency;
    private String code;
    private List<CurrencyRate> rates;
}

@Getter
class CurrencyRate {
    private String no;
    private String effectiveDate;
    private String mid;
}
