package com.intern.gym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.intern.gym.pojo.GymManagement;
import com.intern.gym.service.GymManagementLoginServ;

@CrossOrigin("http://localhost:4200/")
@RestController
public class GymManagementLoginCont {
	@Autowired
	GymManagementLoginServ gmls;

	@PostMapping("/login")
	public String login(@RequestBody GymManagement loginRequest) {
	    String email = loginRequest.getEmail();
	    String password = loginRequest.getPassword();
	    GymManagement userFromDatabase = gmls.findByEmail(email);
	    if (userFromDatabase != null && userFromDatabase.getPassword().equals(password)) {
	        return String.valueOf(userFromDatabase.getUserId());
	    } else {
	        return "0";
	    }
	}



}

