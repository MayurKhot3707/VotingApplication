package com.example.service;

import java.util.List;

import com.example.entity.candidate;

public interface candidateManager 
{
	void addCandidate(candidate candi);
	List<candidate> getCandidates();
	void deleteCandidate(String canname);

}
