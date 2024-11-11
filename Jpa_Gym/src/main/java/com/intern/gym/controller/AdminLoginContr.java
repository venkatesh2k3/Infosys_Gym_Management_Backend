package com.intern.gym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.intern.gym.pojo.AdminLogin;
import com.intern.gym.service.AdminLoginServ;

@CrossOrigin("http://localhost:4200")
@RestController
public class AdminLoginContr {
	 @Autowired
	    private AdminLoginServ adminLoginService;

	    @PostMapping("/admin/login")
	    public String login(@RequestBody AdminLogin adminLogin) {
	        boolean loginSuccess = adminLoginService.validateLogin(adminLogin.getEmail(), adminLogin.getPassword());
	        if (loginSuccess) {
	            return "1";
	        } else {
	            return "0";
	        }
	    }
}
