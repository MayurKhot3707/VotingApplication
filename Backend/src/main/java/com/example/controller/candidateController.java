package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.candidate;
import com.example.service.candidateManager;

@RestController
@CrossOrigin("http://localhost:3000")
public class candidateController 
{
	@Autowired
	candidateManager manager;
	
	@PostMapping("/api/candidate")
	public void addcan(@RequestBody candidate candi)
	{
		manager.addCandidate(candi);
	}
	@GetMapping("/api/candidate")
	public List<candidate> getcan()
	{
		return manager.getCandidates();
	}
	
	@DeleteMapping("/api/candidate/{canname}")
	public void removeCandidate(@PathVariable String canname)
	{
		manager.deleteCandidate(canname);
	}

}
