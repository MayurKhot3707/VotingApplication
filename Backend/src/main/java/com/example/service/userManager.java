package com.example.service;

import java.util.List;

import com.example.entity.user;


public interface userManager 
{
     public void adduser(user users);
     public List<user> getusers();
     
     public void uservote(int userid,int candidateid);
     
     public void updatevotecount(int candidateid);
     
	public List<String> getVoteUsers(int candidateid);
     
}