package com.klu.jfsd.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klu.jfsd.project.entity.Booking;
import com.klu.jfsd.project.entity.User;
import com.klu.jfsd.project.repository.BookingRepository;
import com.klu.jfsd.project.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userrepo;
	@Autowired
	BookingRepository bookrepo;
	
	public void createUser(User user)
	{
		userrepo.save(user);
	}
	public void updateUser(User user)
	{
		Optional<User> li=userrepo.findById(user.getId());
		
		if(li!=null)
		{
			userrepo.save(user);
		}
	}
	public void deleteUser(User user)
	{
		Optional<User> li=userrepo.findById(user.getId());
		if(li!=null)
		{
			userrepo.delete(user);
		}
	}
	public User retrieveUser(String username,String password)
	{
		User ur=userrepo.findByUsernameAndPassword(username, password);
		return ur;
		
	}
	
	public User verify(User u)
	{
		
		return  userrepo.findByUsernameAndPassword(u.getUsername(), u.getPassword());
	}
	
	public Booking book(Booking b)
	{
		Booking ar=bookrepo.save(b);
		return ar;
	}
	
	public List<Booking> retrivebooking()
	{
		List<Booking> bb=bookrepo.findAll();
		return bb;
	}
	
	public void updateProf(User u)
	{
		User us=userrepo.findByRoleSpecifiedId(u.getRole_specified_id());
		u.setId(us.getId());
		u.setRole(us.getRole());
		userrepo.save(u);
	}
	
	public List<User> retUsers()
	{
		return userrepo.findAll();
	}
	
	
}
