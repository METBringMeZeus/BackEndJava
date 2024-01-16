package com.example.QuanLiPT1.Service;

import org.springframework.http.ResponseEntity;
public interface IemailService {
    public ResponseEntity<?> XacNhanUser(String code);
}
