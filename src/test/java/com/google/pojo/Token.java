package com.google.pojo;

public class Token {
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Token(){

    }
    public Token (String token){

        setToken(token);

    }
}
