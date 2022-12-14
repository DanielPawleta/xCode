package com.example.xCode;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@org.springframework.web.bind.annotation.RestController
public class MyController {

    @GetMapping("/status/ping")
    public ResponseEntity<String> getPong(){
        return ResponseEntity.ok("pong");
    }

    @PostMapping("/numbers/sort-command")
    public PostResponse sort(@RequestBody PostRequest postRequest){
        System.out.println("elo");
        PostResponse postResponse = new PostResponse();;
        postResponse.setMessage("Hello " + postRequest.getName());

        return postResponse;
    }

}
