package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.candidate;
import com.example.repository.candidateRepository;

@Service
public class candidateManagerImpl implements candidateManager 
{
	@Autowired
	private candidateRepository repository;

	@Override
	public void addCandidate(candidate candi) {
		repository.save(candi);
		
	}

	@Override
	public List<candidate> getCandidates() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public void deleteCandidate(String canname) {
		int id=repository.getCanId(canname);
		repository.deleteById(id);
		
	}

}
