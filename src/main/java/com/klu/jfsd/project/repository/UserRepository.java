package com.klu.jfsd.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.klu.jfsd.project.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	 User findByUsernameAndPassword(String username,String password);
	 
	 @Query("SELECT u FROM User u WHERE u.role_specified_id = :roleSpecifiedId")
	 User findByRoleSpecifiedId(@Param("roleSpecifiedId") int role_specified_id);
	 

}
