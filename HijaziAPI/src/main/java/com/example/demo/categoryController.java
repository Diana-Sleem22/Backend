package com.example.demo;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class categoryController {
	@Autowired
	private categoryRepository repository;
	@PostMapping("/registerCategory")
    public int registration(  @RequestBody category categoryDto ){
		repository.save( categoryDto);
		return Response.SC_CREATED;
                            
}
	@GetMapping("/getAllCategories")
    public List<category> getCategories(){
		return repository.findAll();
                            
}
    @PutMapping("/updateCategory")  
    private int update(@RequestBody category categoryDto)   
    {  
    
    	repository.save( categoryDto);
		return Response.SC_CREATED; 
    }  
    @DeleteMapping("/deleteCategory/{id}")  
    private void deleteCompany(@PathVariable("id") int companyid) 
    {  
    repository.deleteById(companyid);  
    }  
    @GetMapping("/searchCategories/{name}")
    public ResponseEntity<List<category>> searchCategories(@PathVariable("name") String categoryName){
   	 List<category> categories = null;
        if(categoryName != null){
       	 categories= repository.findByNameLike("%"+categoryName+"%");
           
            return ResponseEntity.ok(categories);
        }

        return ResponseEntity.ok(categories);
   }
}
