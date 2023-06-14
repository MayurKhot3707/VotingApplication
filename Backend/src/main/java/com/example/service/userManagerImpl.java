package com.example.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.user;
import com.example.repository.userRepository;
@Service
public class userManagerImpl implements userManager{
     
	
	@Autowired
	userRepository repo;
	
	@Override
	public void adduser(user users) 
	{
		
      repo.save(users);
	}
   
	@Override
	public List<user> getusers() 
	{
		
		// TODO Auto-generated method stub
		return repo.findAll();
		
	}

	@Override
	public void uservote(int userid, int candidateid) {
		repo.usersvote(userid, candidateid);
		
	}

	@Override
	public void updatevotecount(int candidateid) {
		repo.addvote( candidateid);
		
	}

	@Override
	public List<String> getVoteUsers(int candidateid) {

		return repo.getVoteUsers(candidateid);
	}
}
		
		
		