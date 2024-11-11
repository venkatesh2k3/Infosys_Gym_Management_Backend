package com.intern.gym.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intern.gym.pojo.AdminLogin;

public interface AdminLoginRepo extends JpaRepository<AdminLogin, Integer> {

	AdminLogin findByEmailAndPassword(String email, String password);
}
