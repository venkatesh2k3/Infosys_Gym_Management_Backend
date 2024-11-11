package com.intern.gym.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intern.gym.pojo.AdminLogin;
import com.intern.gym.repo.AdminLoginRepo;

@Service
public class AdminLoginServ {

    @Autowired
    private AdminLoginRepo adminLoginRepository;

    public boolean validateLogin(String email, String password) {
        AdminLogin admin = adminLoginRepository.findByEmailAndPassword(email, password);
        return admin != null;
    }
}