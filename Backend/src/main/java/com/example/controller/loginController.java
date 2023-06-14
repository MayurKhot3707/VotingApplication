package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.loginRequest;
import com.example.dto.loginResponse;
import com.example.service.loginManager;

@RestController
@CrossOrigin("http://localhost:3000")

public class loginController 
{
	@Autowired
	loginManager manager;
	
	@PostMapping("/api/login")
	public ResponseEntity<loginResponse> login(@RequestBody loginRequest request)
	{
		return manager.login(request);
	}

}
