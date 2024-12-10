package com.klu.jfsd.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.klu.jfsd.project.entity.Professional;

public interface ProfessionalRepository extends JpaRepository<Professional, Integer>{
	List<Professional> findByIdIn(List<Integer> professionalIds);

}
