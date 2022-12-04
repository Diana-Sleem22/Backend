package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import models.users;
import repositories.usersRepository;

@Service
public class usersService {
	@Autowired
	private usersRepository repo;
	
    public List<users> listAll(){
    	return repo.findAll();
    }
    
}