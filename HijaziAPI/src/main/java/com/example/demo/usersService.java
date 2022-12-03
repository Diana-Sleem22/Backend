package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class usersService {
	@Autowired
	private usersRepository repo;
	
    public List<users> listAll(){
    	return repo.findAll();
    }
    
}
