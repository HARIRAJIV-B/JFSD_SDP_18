package com.klu.jfsd.project.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.klu.jfsd.project.entity.Booking;
import com.klu.jfsd.project.entity.Client;
import com.klu.jfsd.project.entity.Professional;
import com.klu.jfsd.project.entity.User;
import com.klu.jfsd.project.repository.BookingRepository;
import com.klu.jfsd.project.repository.ClientRepository;
import com.klu.jfsd.project.repository.ProfessionalRepository;

@Service
public class ProfessionalService {

	@Autowired
	ProfessionalRepository profrepo;
	
	@Autowired
	UserService userservice;
	
	@Autowired
	BookingRepository bookrepo;
	
	@Autowired
	ClientRepository clientrepo;
	
	
	
	
	public String addProf(Professional p)
	{
		profrepo.save(p);
		User u=new User();
		u.setUsername(p.getName());
		u.setPassword(p.getPassword());
		u.setRole("professional");
		u.setRole_specified_id(p.getId());
		userservice.createUser(u);
		
		return "Professional Added Successfully";
	}
	
	public Optional<Professional> getProf(int id)
	{
		return profrepo.findById(id);
	}
	
	public Optional<Professional> upProf(Professional p)
	{
		profrepo.save(p);
		User u=new User();
		u.setRole_specified_id(p.getId());
		u.setPassword(p.getPassword());
		u.setUsername(p.getName());
		userservice.updateProf(u);
		return profrepo.findById(p.getId());
		
	}
	
	public List<Client> bookingsret(int id)
	{
		List<Booking> b=bookrepo.findByProfessionalid(id);
		List<Client> c=new ArrayList<>();
		for(int i=0;i<b.size();i++)
		{
			Booking bb=b.get(i);
			Optional<Client> cc=clientrepo.findById(bb.getUserid());
			c.add(cc.get());
		}
		return c;
	}
	
	public List<Professional> retProf()
	{
		return profrepo.findAll();
	}
}
