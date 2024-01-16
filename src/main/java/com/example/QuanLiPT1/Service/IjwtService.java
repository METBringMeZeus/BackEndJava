package com.example.QuanLiPT1.Service;

import com.example.QuanLiPT1.DTO.Request.LoginRequest;
import com.example.QuanLiPT1.DTO.Response.TokenResponse;
import com.example.QuanLiPT1.DTO.Response.jwtAuthenticationResponse;
import com.example.QuanLiPT1.Entity.RefreshToken;
import com.example.QuanLiPT1.Entity.User;

public interface IjwtService {
    String Login(LoginRequest loginRequest);

}
