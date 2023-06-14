package com.example.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.temp;
import com.example.entity.user;
import com.example.service.userManager;

@RestController
@CrossOrigin("http://localhost:3000")
public class userController
{

	@Autowired
	private userManager manager;
	
	@PostMapping("api/users")
	 public void adduser(@RequestBody user users)
	 {
		System.out.println(users.toString());
		manager.adduser(users);
	 }
	
	@GetMapping("api/users")
	public List<user> getusers()
	{
		return manager.getusers();

	}
	
	@GetMapping("api/voteusers/{id}")
	public List<String> getVotedUser(@PathVariable int id)
	{
		return manager.getVoteUsers(id);

	}
}