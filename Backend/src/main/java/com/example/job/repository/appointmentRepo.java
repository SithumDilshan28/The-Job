package com.example.job.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.job.model.appointment;

public interface appointmentRepo extends JpaRepository<appointment, Long>{
	
	 @Query(value = "SELECT COUNT(*) FROM appointment", nativeQuery = true)
	    long countAllAppointments();

	 
	 @Query(value = "SELECT * FROM appointment WHERE email = :email", nativeQuery = true)
	    List<appointment> findByCounsultEmail(@Param("email") String email);
}
