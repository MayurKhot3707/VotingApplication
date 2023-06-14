package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.admin;
import com.example.repository.adminRepository;

@Service
public class adminManagerImpl implements adminManager
{
	@Autowired
	private adminRepository repository;

	@Override
	public void addAdmin(admin admins) 
	{
		repository.save (admins);
	}
	
	
	
}

