package com.example.QuanLiPT1.Repository;

import com.example.QuanLiPT1.Entity.XacNhanEmail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface XacNhanEmailRepository extends JpaRepository<XacNhanEmail,Integer> {

}
