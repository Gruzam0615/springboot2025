package com.example.springboot01.utils;

import lombok.Data;

@Data
public class CustomRespons {
    
    private int statusCode;
    private Object data;
    private String message;

}
