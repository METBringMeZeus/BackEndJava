package com.example.QuanLiPT1.Service;

import com.example.QuanLiPT1.Config.JwtTokenProvider;
import com.example.QuanLiPT1.DTO.Request.LoginRequest;
import com.example.QuanLiPT1.DTO.Response.TokenResponse;
import com.example.QuanLiPT1.DTO.Response.jwtAuthenticationResponse;
import com.example.QuanLiPT1.Entity.*;
import com.example.QuanLiPT1.Repository.RegistrationFormRepository;
import com.example.QuanLiPT1.Repository.UserRepository;
import com.example.QuanLiPT1.Repository.XacNhanEmailRepository;
import com.example.QuanLiPT1.Repository.refreshTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Optional;
import java.util.UUID;

@Service
public class jwtService implements IjwtService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    public UserRepository userRepository;
    @Autowired
    public XacNhanEmailRepository xacNhanEmailRepository;
    @Autowired
    public refreshTokenRepository refreshTokenRepository;
    @Autowired
    RegistrationFormRepository registrationFormRepository;
    @Transactional
    @Override
    public String Login(LoginRequest loginRequest) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),loginRequest.getPassword()));
        Optional<User> findByUserName = userRepository.FindByName(loginRequest.getUsername());
        long timeExpiration = jwtTokenProvider.TimeExpiration();
        if(findByUserName.isPresent()){
            String jwtToken = jwtTokenProvider.generateToken(new CustomUserDetails(findByUserName.get()));
            RefreshToken refreshToken = RefreshToken.builder()
                    .user(findByUserName.get())
                    .token(jwtToken)
                    .ThoiGianHetHan(timeExpiration)
                    .build();
            refreshTokenRepository.save(refreshToken);
            return jwtToken;
        }
        else {
            return null;
        }
    }
    @Transactional
    public ResponseEntity<?> RegisterForm(RegistrationForm registrationForm){
        if(isLoggedIn()){
            registrationForm.setTrangThaiDonID(1);
            registrationFormRepository.save(registrationForm);
            return new ResponseEntity<>("Gui form thanh cong", HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Chưa được đăng nhập ",HttpStatus.NOT_FOUND);
        }
    }
    public ResponseEntity<?> ConfirmRegisterForm(int dondangkiID) {

        Optional<RegistrationForm> registrationForm = registrationFormRepository.findById(dondangkiID);
        if (registrationForm.isPresent()) {
            registrationForm.get().setTrangThaiDonID(1);
            registrationForm.get().setNgayXuLi(LocalDate.now());
            registrationFormRepository.save(registrationForm.get());
            return new ResponseEntity<>("Xu li thanh cong ", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("khong tim thay ", HttpStatus.NOT_FOUND);
        }
    }
    public boolean isLoggedIn(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication!=null && authentication.isAuthenticated();
    }





}
