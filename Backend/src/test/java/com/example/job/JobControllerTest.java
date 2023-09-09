package com.example.job;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.job.model.job;


@SpringBootTest
public class JobControllerTest {
	
	@Autowired
	com.example.job.repository.jobRepo jobRepo;

	@Test
	public void testConsultSave() {
		job job = new job();
		job.setId(3L);
		job.setRole("Software Developer");
		job.setCompany("WSO2");
		job.setExperience("1 Year");
		job.setCountry("America");
		job.setSalary("150,000 USD");
		job.setCategory("IT");
		job.setType("Full Time");
		job.setStatus("Urgent");
		job.setImageurl("ImageURL");
		jobRepo.save(job);
		assertNotNull(jobRepo.findById(3L).get());
	}

	@Test
	public void testReadAllConsult() {
		List<job> list1 = jobRepo.findAll();
		assertThat(list1).size().isGreaterThan(0);
	}

	@Test
	public void testUpdateConsult() {
		job job = jobRepo.findById(2L).get();
		job.setCategory("Back End DEV");
		jobRepo.save(job);
		assertNotEquals("Keyboard", jobRepo.findById(2L).get().getCategory());
	}

	@Test
	public void testDelete() {
		jobRepo.deleteById(1L);
		assertThat(jobRepo.existsById(1L)).isFalse();
	}

}
