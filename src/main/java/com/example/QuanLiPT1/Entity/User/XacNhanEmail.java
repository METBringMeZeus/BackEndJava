package com.example.QuanLiPT1.Entity.User;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Builder
@Table(name = "xacnhanemail")
public class XacNhanEmail {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "xacnhanemailid")
    private int XacNhanEmailID;
    @Column(name = "userid",insertable = false,updatable = false)
    private int UserID;
    @Column(name = "thoigianhethan")
    private LocalDate ThoiGianHetHan;
    @Column(name = "maxacnhan")
    private String MaXacNhan;
    @Column(name = "daxacnhan")
    private boolean DaXacNhan;
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "userid")
    private User user;


}
