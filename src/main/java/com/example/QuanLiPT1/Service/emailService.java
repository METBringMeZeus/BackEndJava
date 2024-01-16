package com.example.QuanLiPT1.Service;

import com.example.QuanLiPT1.DTO.Request.RegisterRequest;
import com.example.QuanLiPT1.DTO.Response.MessageResponse;
import com.example.QuanLiPT1.Entity.Decentralization;
import com.example.QuanLiPT1.Entity.User;
import com.example.QuanLiPT1.Entity.XacNhanEmail;
import com.example.QuanLiPT1.Enum.QuyenHanEnum;
import com.example.QuanLiPT1.Repository.DecentralizationRepository;
import com.example.QuanLiPT1.Repository.UserRepository;
import com.example.QuanLiPT1.Repository.XacNhanEmailRepository;
import com.example.QuanLiPT1.Untils.OTPuntils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class emailService {
    @Autowired
    public UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    public XacNhanEmailRepository xacNhanEmailRepository;
    @Autowired
    private DecentralizationRepository decentralizationRepository;
    @Transactional
    public ResponseEntity<?> XacNhanUser(String code){
        for(int i=0;i<xacNhanEmailRepository.findAll().size();i++){
            if(code.equals(xacNhanEmailRepository.findAll().get(i).getMaXacNhan())){
                XacNhanEmail xacNhanEmail = xacNhanEmailRepository.findAll().get(i);
                xacNhanEmail.setDaXacNhan(true);
                xacNhanEmailRepository.save(xacNhanEmail);
                return new ResponseEntity<>("Ok", HttpStatus.OK);
            }
        }
        return new ResponseEntity<>("fail", HttpStatus.NO_CONTENT);

    }
    @Transactional
    public MessageResponse Register(RegisterRequest registerRequest){
        Optional<User> userCheck = userRepository.FindByName(registerRequest.getUsername());
        if(userCheck.isPresent()){
            return MessageResponse.builder().Message("Tai khoan da ton tai ").build();
        }
        Optional<Decentralization> quyenHan = decentralizationRepository.findByAuthorityName(QuyenHanEnum.USER.toString());
        User user = User
                .builder()
                .TenTK(registerRequest.getUsername())
                .MatKhau(passwordEncoder.encode(registerRequest.getPassword()))
                .Email(registerRequest.getEmail())
                .decentralization(quyenHan.get())
                .build();
        try {
            userRepository.save(user);
            OTPuntils otpUntils = new OTPuntils();
            String code = otpUntils.GenerateOTP();
            XacNhanEmail xacNhanEmail = new XacNhanEmail();
            xacNhanEmail.setUser(user);
            xacNhanEmail.setMaXacNhan(code);
            xacNhanEmailRepository.save(xacNhanEmail);
            sendConfirmationEmail(user.getEmail(),code);
            return MessageResponse.builder().Message("Can 1 buoc nua de xac nhan ").build();
        }
        catch (Exception e){
            return MessageResponse.builder().Message("Loi trong qua trinh dang ki").build();
        }
    }

    @Autowired
    public JavaMailSender javaMailSender;
    @Transactional
    public void sendConfirmationEmail(String recipientEmail, String confirmationCode) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(recipientEmail);
        mailMessage.setSubject("Xác nhận đăng ký tài khoản");
        mailMessage.setText("Mã xác nhận của bạn là: " + confirmationCode);

        javaMailSender.send(mailMessage);
    }
}
