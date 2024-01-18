package com.example.QuanLiPT1.Service;

import com.example.QuanLiPT1.DTO.Request.LoginRequest;

public interface IjwtService {
    String Login(LoginRequest loginRequest);

}
