package com.example.xCode;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MyController {

    @GetMapping("/status/ping")
    public ResponseEntity<String> getPong(){
        return ResponseEntity.ok("pong");
    }

    @PostMapping("/numbers/sort-command")
    public NumbersPostResponse sort(@Valid @RequestBody NumbersPostRequest postRequest){
        NumbersPostResponse postResponse = new NumbersPostResponse();
        postResponse.setNumbers(postRequest.sortNumbers());
        return postResponse;
    }

    @PostMapping("/currencies/get-current-currency-value-command")
    public CurrencyPostResponse getCurrentCurrencyValue(@Valid @RequestBody CurrencyPostRequest postRequest){
        CurrencyPostResponse currencyPostResponse = new CurrencyPostResponse();

        String uri;
        uri = String.format("http://api.nbp.pl/api/exchangerates/rates/a/%s/",postRequest.getCurrency());

        RestTemplate restTemplate = new RestTemplate();

        CurrencyNBPResponse currencyNBPResponse = restTemplate.getForObject(uri, CurrencyNBPResponse.class);

        currencyPostResponse.setValue(currencyNBPResponse.getRates().get(0).getMid());
        return currencyPostResponse;
    }
}
