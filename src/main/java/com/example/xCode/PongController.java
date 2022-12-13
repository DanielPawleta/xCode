package com.example.xCode;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PongController {

    @GetMapping("/status/ping")
    public ResponseEntity<String> getPong(){
        return ResponseEntity.ok("pong");
    }

}
