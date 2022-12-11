package com.example.demo;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class companyController {
	@Autowired
	private companyRepository repository;

	 
	@PostMapping("/registerCompany")
    public int registration(  @RequestBody company companyDto ){
		repository.save(companyDto);
		return Response.SC_CREATED;
                            
}
	
	@GetMapping("/getAllCompanies")
    public List<company> getCompany(){
		return repository.findAll();
                            
}
    @PutMapping("/updateCompany")  
    private int update(@RequestBody company companyDto )   
    {  
    
    	repository.save(companyDto);
		return Response.SC_CREATED; 
    }  
    @DeleteMapping("/deleteCompany/{id}")  
    private void deleteCompany(@PathVariable("id") int companyid) 
    {  
    repository.deleteById(companyid);  
    }  
    @GetMapping("/searchCompanies/{name}")
    public ResponseEntity<List<company>> searchCompanies(@PathVariable("name") String companyName){
    	 List<company> company = null;
         if(companyName != null){
             company= repository.findByNameLike("%"+companyName+"%");
            
             return ResponseEntity.ok(company);
         }
 
         return ResponseEntity.ok(company);
    }
}
