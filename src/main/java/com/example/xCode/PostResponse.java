package com.example.xCode;

public class PostResponse {
    private final String WRONG_ORDER_RESPONSE = "Please type only ASC or DESC";
    private String response;

    public void setResponse(String response) {
        this.response = response;
    }

    public PostResponse() {
        System.out.println("elo2");
    }

    public String getResponse() {
        return response;
    }
}
