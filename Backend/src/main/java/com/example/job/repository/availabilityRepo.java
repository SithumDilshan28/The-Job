package com.example.job.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.job.model.availability;

public interface availabilityRepo extends JpaRepository<availability, Long> {
	
	@Query(value = "SELECT * FROM availability " +
            "WHERE date = :selectedDate " +
            "AND timeslot = :selectedTimeslot", nativeQuery = true)
List<availability> findByDateAndTimeslot(
     @Param("selectedDate") String selectedDate,
     @Param("selectedTimeslot") String selectedTimeslot);
}


