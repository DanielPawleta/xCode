package com.example.xCode;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@org.springframework.web.bind.annotation.RestController
public class MyController {

    @GetMapping("/status/ping")
    public ResponseEntity<String> getPong(){
        return ResponseEntity.ok("pong");
    }

    @PostMapping("/numbers/sort-command")
    public PostResponse sort(@Valid @RequestBody PostRequest postRequest){

        System.out.println("metoda sort w controller");
        PostResponse postResponse = new PostResponse();
        postResponse.setResponse(String.valueOf(postRequest.getNumbers()));

        return postResponse;
    }

}
