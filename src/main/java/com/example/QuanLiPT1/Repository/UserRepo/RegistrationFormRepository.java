package com.example.QuanLiPT1.Repository.UserRepo;

import com.example.QuanLiPT1.Entity.User.RegistrationForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface RegistrationFormRepository extends JpaRepository<RegistrationForm,Integer> {
}
