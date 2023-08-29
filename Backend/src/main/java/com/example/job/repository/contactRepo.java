package com.example.job.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.job.model.contact;

public interface contactRepo extends JpaRepository<contact, Long> {

}
