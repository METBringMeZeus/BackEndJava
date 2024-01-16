package com.example.QuanLiPT1.Repository;

import com.example.QuanLiPT1.Entity.RefreshToken;
import com.example.QuanLiPT1.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface refreshTokenRepository extends JpaRepository<RefreshToken,Integer> {
}
