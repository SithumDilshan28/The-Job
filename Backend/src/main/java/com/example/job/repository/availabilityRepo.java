package com.example.job.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.job.model.availability;

public interface availabilityRepo extends JpaRepository<availability, Long> {

}
