package com.example.QuanLiPT1.Service;

import com.example.QuanLiPT1.Entity.User.CustomUserDetails;
import com.example.QuanLiPT1.Entity.User.User;
import com.example.QuanLiPT1.Repository.UserRepo.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Optional;
@Service
public class UserService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.FindByName(username);
        if(user.isEmpty()){
            throw new UsernameNotFoundException(username);
        }
        else {
            return new CustomUserDetails(user.get());
        }
    }

}
