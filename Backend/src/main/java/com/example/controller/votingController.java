	package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.temp;
import com.example.service.userManager;

@RestController
@CrossOrigin("http://localhost:3000")

public class votingController
{
	@Autowired
	private userManager manager;
	
	@PostMapping("/api/vote")
	public void vote(@RequestBody temp votedetails)
	{
		manager.uservote(votedetails.getUserid(),votedetails.getCandidateid());
		manager.updatevotecount(votedetails.getCandidateid());
	}

	
}
