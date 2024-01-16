package com.example.QuanLiPT1.Repository;

import com.example.QuanLiPT1.Entity.RegistrationForm;
import jakarta.persistence.Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface RegistrationFormRepository extends JpaRepository<RegistrationForm,Integer> {
}
