package com.klu.jfsd.project.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.klu.jfsd.project.entity.Client;
import com.klu.jfsd.project.entity.Professional;
import com.klu.jfsd.project.service.ProfessionalService;

@RestController
@RequestMapping("/professional")
@CrossOrigin
public class ProfessionalController {

	@Autowired
	ProfessionalService profser;
	
	@PostMapping("/add")
	public Professional addProfessional(@RequestBody Professional p)
	{
		System.out.println(profser.addProf(p));
		System.out.println(p.getAadhar());
		return p;
		
	}
	
	@GetMapping("/retrieve")
	public List<Professional> retProf()
	{
		return profser.retProf();
	}
	
	@GetMapping("/get")	
	public Optional<Professional> getProfessional(@RequestParam int id)
	{
		System.out.println(id);
		return profser.getProf(id);
	}
	
	@PutMapping("/update")
	public Optional<Professional> updateProfessional(@RequestBody Professional p)
	{
		return profser.upProf(p);
	}
	
	@GetMapping("/bookings")
	public List<Client> Bookings(@RequestParam int id)
	{
		return profser.bookingsret(id);
	}
	
}
