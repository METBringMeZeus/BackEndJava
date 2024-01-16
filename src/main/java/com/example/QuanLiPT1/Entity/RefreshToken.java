package com.example.QuanLiPT1.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.context.annotation.Configuration;

import javax.xml.crypto.Data;
import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "refreshtoken")
@Builder
public class RefreshToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "refreshtokenid")
    private int RefreshTokenID;
    @Column(name = "token")
    private String token;
    @Column(name = "thoigianhethan")
    private long ThoiGianHetHan;
    @Column(name = "userid",insertable = false,updatable = false)
    private int UserID;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "userid")
    public User user;

}
