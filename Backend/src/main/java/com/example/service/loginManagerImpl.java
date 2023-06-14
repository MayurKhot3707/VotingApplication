package com.example.service;

import com.example.dto.adminLoginResponse;
import com.example.dto.loginRequest;
import com.example.dto.loginResponse;
import com.example.dto.temp;
import com.example.entity.user;
import com.example.repository.userRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class loginManagerImpl implements loginManager {

    @Autowired
    private userRepository repository;
    
   
    public ResponseEntity<loginResponse> login(loginRequest request) {
        user person = repository.findAll().stream()
                .filter(user -> user.getUsername().equals(request.getUsername()) && user.getPassword().equals(request.getPassword()))
                .findFirst()
                .orElse(null);

        if (person != null && person.getUsername().equals(request.getUsername()) && person.getPassword().equals(request.getPassword())) 
        {
            boolean check = checkCanId(person.getUserid());
            if(check==true)
            {
                return ResponseEntity.ok().body(new loginResponse(true, person));

            }
            else
                return ResponseEntity.ok().body(new loginResponse(false, null));

        } 
        else if (person != null && person.getUsername().equals(request.getUsername()) && person.getPassword().equals(request.getPassword())) 
        {
           
        	return ResponseEntity.ok().body(new loginResponse(true, person));
        } 
        else
        {
            return ResponseEntity.ok().body(new loginResponse(false, null));
        }
    }

    public boolean checkCanId(int u) 
    {
    	user temp=getUserByUid(u);
    	if (temp.getCandidateid()==null)
    	{
    		return true;
    	}
    	else
    		return false;
    }
    
    
    public user getUserByUid(int uid) {
        return repository.findByUid(uid);
    }
}
