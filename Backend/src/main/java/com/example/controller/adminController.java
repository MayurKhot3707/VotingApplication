package com.example.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.admin;
import com.example.entity.candidate;
import com.example.service.adminManager;
import com.example.service.candidateManager;

@RestController
@CrossOrigin("http://localhost:3000")
public class adminController 
{

	@Autowired
	private adminManager manager;
	
	@Autowired
	private candidateManager canmanage;
	
	@PostMapping("api/admin")
	 public void addadmin(@RequestBody admin admins)
	 {
		manager.addAdmin(admins);
	 }
	
	@GetMapping("api/votetally")
	public List<candidate> getTally()
	{
		return canmanage.getCandidates();
	}
	

}
