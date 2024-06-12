package com.example.Sun_Base_Customer_Application.payload;

import lombok.Data;
@Data
public class LoginRequest {
    private String username;
    private String password;
}