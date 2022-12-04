package controllers;

import java.util.List;

import org.apache.tomcat.jni.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import models.users;
import services.usersService;

@RestController
public class usersController {
	@Autowired
	private usersService service;
	
	 @GetMapping("/allusers")
	 public List<users> list(){
			return service.listAll();
		}


}
