package com.example.job;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.job.model.availability;


@SpringBootTest
public class AvailabilityControllerTest {
	
	
	@Autowired
	com.example.job.repository.availabilityRepo availabilityRepo;

	@Test
	public void testConsultSave() {
		availability availability = new availability();
		availability.setId(3L);
		availability.setDate("08-10-2023");
		availability.setTimeslot("11:00 AM - 12:00 PM");
		availability.setFullname("Shanu");
		availability.setImageurl("ImageURL");
		availability.setSpecilizedjobtype("IT");
		availability.setSpecilizedcountry("Canada");
		availability.setPhone("0785552563");
		availability.setEmail("Shanzaggy@gmail.com");
		availabilityRepo.save(availability);
		assertNotNull(availabilityRepo.findById(3L).get());
	}

	@Test
	public void testReadAllConsult() {
		List<availability> list1 = availabilityRepo.findAll();
		assertThat(list1).size().isGreaterThan(0);
	}

	@Test
	public void testUpdateConsult() {
		availability availability = availabilityRepo.findById(2L).get();
		availability.setEmail("Shan2008@gmail.com");
		availabilityRepo.save(availability);
		assertNotEquals("Keyboard", availabilityRepo.findById(2L).get().getEmail());
	}

	@Test
	public void testDelete() {
		availabilityRepo.deleteById(1L);
		assertThat(availabilityRepo.existsById(1L)).isFalse();
	}

}
