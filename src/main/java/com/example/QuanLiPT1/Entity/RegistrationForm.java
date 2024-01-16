package com.example.QuanLiPT1.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "dondangki")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegistrationForm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dondangkiID")
    private int DonDangKiID;
    @Column(name = "ngayguidon")
    private LocalDate NgayGuiDon;
    @Column(name = "ngayxuli")
    private LocalDate NgayXuLi;
    @Column(name = "nguoixuli")
    private String NguoiXuLi;
    @Column(name = "trangthaidonid",insertable = false,updatable = false)
    private int TrangThaiDonID;
    @Column(name = "trangid")
    private int TrangID;
    @Column(name = "userid",insertable = false,updatable = false)
    private int UserID;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "userid")
    private User user;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "trangthaidonid")
    private Status status;
}
