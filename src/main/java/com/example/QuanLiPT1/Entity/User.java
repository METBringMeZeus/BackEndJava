package com.example.QuanLiPT1.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "user")
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userid")
    private int UserID;
    @Column(name = "tentk")
    private String TenTK;
    @Column(name = "image")
    private String Image;
    @Column(name = "dahoantuc")
    private boolean DaHoanTuc;
    @Column(name = "email")
    private String Email;
    @Column(name = "gioitinh")
    private String GioiTinh;
    @Column(name = "ngaycapnhat")
    private LocalDate NgayCapNhat;
    @Column(name = "ngayhoantuc")
    private LocalDate NgayHoanTuc;
    @Column(name = "ngaysinh")
    private LocalDate NgaySinh;
    @Column(name = "matkhau")
    private String MatKhau;
    @Column(name = "phapdanh")
    private String PhapDanh;
    @Column(name = "sdt")
    private String SoDienThoai;
    @Column(name = "chuaid")
    private int ChuaID;
    @Column(name = "quyenhanid",insertable = false,updatable = false)
    private int QuyenHanID;
    @JsonManagedReference
    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
    private List<XacNhanEmail> xacNhanEmails;
    @JsonManagedReference
    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
    private List<RefreshToken> refreshTokens;
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "quyenhanid")
    private Decentralization decentralization;
    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<RegistrationForm> registrationForms;

}
