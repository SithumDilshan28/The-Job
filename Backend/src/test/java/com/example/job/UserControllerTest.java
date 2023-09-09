package com.example.job;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.job.model.user;


@SpringBootTest
public class UserControllerTest {
	
	@Autowired
	com.example.job.repository.userRepo userRepo;

	@Test
	public void testConsultSave() {
		user user = new user();
		user.setId(42L);
		user.setFirstname("Shanuka");
		user.setLastname("Sithum");
		user.setNic("NIC");
		user.setDob("15-12-1999");
		user.setSex("Male");
		user.setMaritalStatus("Single");
		user.setAddress("Sri Lanka");
		user.setPhone("0741452456");
		user.setEmail("shanu@gmail.com ");
		user.setPassword("shanu@123");
		user.setEducation("Bsc");
		user.setCollege("ICBT");
		user.setJob("Student");
		user.setRole("Student");
		userRepo.save(user);
		assertNotNull(userRepo.findById(42L).get());
	}

	@Test
	public void testReadAllConsult() {
		List<user> list1 = userRepo.findAll();
		assertThat(list1).size().isGreaterThan(0);
	}

	@Test
	public void testUpdateConsult() {
		user user = userRepo.findById(2L).get();
		user.setEmail("shanu@gmail.com");
		userRepo.save(user);
		assertNotEquals("Keyboard", userRepo.findById(2L).get().getEmail());
	}

	@Test
	public void testDelete() {
		userRepo.deleteById(1L);
		assertThat(userRepo.existsById(1L)).isFalse();
	}

}
