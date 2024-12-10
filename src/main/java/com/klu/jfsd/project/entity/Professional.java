package com.klu.jfsd.project.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Professional {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private long aadhar;
    private int age;
	private String email;
    private String profilePhoto;
    private String services; 
    private String name;
    private String address;
    private int number;
    private String password;


    public String getProfilePhoto() {
    	return profilePhoto;
    }
    public void setProfilePhoto(String profilePhoto) {
    	this.profilePhoto = profilePhoto;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public long getAadhar() {
        return aadhar;
    }
    public void setAadhar(long aadhar) {
        this.aadhar = aadhar;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    

    public String getServices() {
        return services;
    }
    public void setServices(String services) {
        this.services = services;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

  
}
