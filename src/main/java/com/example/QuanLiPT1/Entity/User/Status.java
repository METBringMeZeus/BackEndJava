package com.example.QuanLiPT1.Entity.User;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "trangthaidon")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "trangthaidonid")
    private int TrangThaiDonID;
    @Column(name = "tentrangthai")
    private String TenTrangThai;
    @OneToMany(mappedBy = "status",fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<RegistrationForm> registrationForms;
}
