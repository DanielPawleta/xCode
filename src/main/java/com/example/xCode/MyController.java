package com.example.xCode;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @GetMapping("/status/ping")
    public ResponseEntity<String> getPong(){
        return ResponseEntity.ok("pong");
    }

    @PostMapping("/numbers/sort-command")
    public NumbersPostResponse sort(@Valid @RequestBody NumbersPostRequest postRequest){

        System.out.println("metoda sort w controller");
        NumbersPostResponse postResponse = new NumbersPostResponse();
        postResponse.setNumbers(postRequest.getNumbers());

        return postResponse;
    }

    @PostMapping("/currencies/get-current-currency-value-command")
    public CurrencyPostResponse getCurrentCurrencyValue(@Valid @RequestBody CurrencyPostRequest postRequest){

        System.out.println("metoda get currency w controller");
        CurrencyPostResponse currencyPostResponse = new CurrencyPostResponse();
        currencyPostResponse.setCurrencyValue(postRequest.getCurrencyName());

        return currencyPostResponse;
    }

}
