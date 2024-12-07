package com.klu.jfsd.project.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.klu.jfsd.project.entity.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {
	List<Booking> findByUserid(int userid);
	
	 @Query("SELECT u FROM Booking u WHERE u.professionalid = :professionalid")
	 List<Booking> findByProfessionalid(@Param("professionalid") int professionalid);

}
