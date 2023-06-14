package com.example.service;

import org.springframework.http.ResponseEntity;

import com.example.dto.adminLoginResponse;
import com.example.dto.loginRequest;
import com.example.dto.loginResponse;

public interface loginManager {
	ResponseEntity<loginResponse> login(loginRequest request);

}
