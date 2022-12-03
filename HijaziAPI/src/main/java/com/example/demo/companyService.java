package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;

public class companyService {
	@Autowired
	private companyRepository repo;
	
	  public void saveUser(company companyDto) {
	     company com=new company();
	     com.setName(companyDto.getName());
	     com.setPhone(companyDto.getPhone());
	     repo.save(com);
	    }
}
