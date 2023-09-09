package com.example.job;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.job.model.consultant;

@SpringBootTest
public class ConsultControllerTest {
	
	@Autowired
	com.example.job.repository.consultantRepo consultantRepo;

	@Test
	public void testConsultSave() {
		consultant consultant = new consultant();
		consultant.setId(3L);
		consultant.setFullname("shanu");
		consultant.setEmail("Shanuzaggy@gmail.com");
		consultant.setPassword("Shanu@123");
		consultant.setNic("NIC");
		consultant.setPhone("0758775848");
		consultant.setAddress("Gampaha");
		consultant.setSpecilizedcountry("Australia");
		consultant.setSpecilizedjobtype("Software Developer");
		consultant.setImageurl("ImageURL");
		consultantRepo.save(consultant);
		assertNotNull(consultantRepo.findById(3L).get());
	}

	@Test
	public void testReadAllConsult() {
		List<consultant> list1 = consultantRepo.findAll();
		assertThat(list1).size().isGreaterThan(0);
	}

	@Test
	public void testUpdateConsult() {
		consultant consultant = consultantRepo.findById(2L).get();
		consultant.setEmail("hanu00@gmail.com");
		consultantRepo.save(consultant);
		assertNotEquals("Keyboard", consultantRepo.findById(2L).get().getEmail());
	}

	@Test
	public void testDelete() {
		consultantRepo.deleteById(1L);
		assertThat(consultantRepo.existsById(1L)).isFalse();
	}

}
