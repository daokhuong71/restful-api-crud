package com.daoquangkhuong.demo.config;

import com.fasterxml.jackson.databind.ObjectMapper;

public class AppConfig {
    public ObjectMapper objectMapper(){
        return new ObjectMapper();
    }
}
