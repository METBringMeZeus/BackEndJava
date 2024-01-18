package com.example.QuanLiPT1.Service;
import com.example.QuanLiPT1.Repository.UserRepo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
public class PageableService {
    @Autowired
    UserRepository userRepository;
    public Pageable FindByEmailPage(Integer numPage, Integer size){
        Pageable pageable = PageRequest.of(numPage,size);
        return (Pageable) userRepository.FindByEmailPage(pageable);

    }
    public Pageable FindByNamePage(Integer numPage, Integer size){
        Pageable pageable = PageRequest.of(numPage,size);
        return (Pageable) userRepository.FindByNamePage(pageable);

    }
    public Pageable FindByGenderPage(Integer numPage, Integer size){
        Pageable pageable = PageRequest.of(numPage,size);
        return (Pageable) userRepository.FindByGenderPage(pageable);

    }
}
