package com.klu.jfsd.project.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.klu.jfsd.project.entity.Professional;
import com.klu.jfsd.project.entity.User;
import com.klu.jfsd.project.service.ClientService;
import com.klu.jfsd.project.service.UserService;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userser;
	@Autowired
	ClientService clser;
	
	@PostMapping("/create")
	public ResponseEntity<?> createUser(@RequestBody User user)
	{
		userser.createUser(user);
		return ResponseEntity.ok("Done");
	}
	
	@PostMapping("/check")
	public User check(@RequestBody User u)
	{
		User rec=userser.verify(u);
		if(rec!=null)
		{
			
		System.out.println(rec.getId());
		return rec;
		}
		else
			return null;
	}
	
	@GetMapping("/getprof")
	public List<Professional> getprof()
	{
		return clser.getProf();
	}
	
	@GetMapping("/retrieve")
	public List<User> retrieve()
	{
		return userser.retUsers();
	}
	
	


}
