package com.klu.jfsd.project.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.klu.jfsd.project.entity.Booking;
import com.klu.jfsd.project.entity.Client;
import com.klu.jfsd.project.service.ClientService;
import com.klu.jfsd.project.service.UserService;

@RestController
@RequestMapping("/client")
@CrossOrigin
public class ClientController {

	@Autowired
	ClientService ser;
	@Autowired
	UserService user;
	@PostMapping("/add")
	public Client addClient(@RequestBody Client c)
	{
		System.out.println(ser.addClient(c));
		return c;
		
	}
	
	@PostMapping("/book")
	public Booking book(@RequestBody Booking b)
	{
		user.book(b);
		return b;
	}
	
	@GetMapping("booked-professionals")
	public List<Booking> booked()
	{
		return user.retrivebooking();
	}
	
	@GetMapping("/retrieve")
	public List<Client> retUsers()
	{
		return ser.retClients();
	}
	
	

}
