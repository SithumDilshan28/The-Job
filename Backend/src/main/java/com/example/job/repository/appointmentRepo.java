package com.example.job.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.job.model.appointment;

public interface appointmentRepo extends JpaRepository<appointment, Long>{

}
