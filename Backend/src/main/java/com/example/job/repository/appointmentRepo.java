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
	    
	    
	    
	    
	    @Query(
	            value = "SELECT a.consultantname, COUNT(*) AS appointment_count, c.specilizedcountry " +
	                    "FROM appointment a " +
	                    "LEFT JOIN consultant c ON a.consultantname = c.fullname " +
	                    "GROUP BY a.consultantname, c.specilizedcountry " +
	                    "ORDER BY appointment_count DESC",
	            nativeQuery = true
	        )
	        List<Object[]> consultantperformance();
	        
	        
	        @Query(
	        	    value = "SELECT * FROM appointment WHERE date >= CURRENT_DATE() ORDER BY date ASC",
	        	    nativeQuery = true
	        	)
	        	List<appointment> findUpcomingAppointmentsOrderByDateAsc();
}
