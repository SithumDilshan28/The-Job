package com.example.job;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.job.model.contact;

@SpringBootTest
public class ContactControlletTest {
	
	@Autowired
	com.example.job.repository.contactRepo contactRepo;

	@Test
	public void testAppointmentSave() {
		contact contact = new contact();
		contact.setId(2L);
		contact.setName("Shanu Zaggy");
		contact.setEmail("Shanu@gmail.com");
		contact.setPhone("0758256321");
		contact.setMessage("Hi...");
		contactRepo.save(contact);
		assertNotNull(contactRepo.findById(2L).get());
	}
	
	@Test
	public void testReadAllAppointment() {
		List<contact> list1 = contactRepo.findAll();
		assertThat(list1).size().isGreaterThan(0);
	}
	
	@Test
	public void testDeleteAppointment() {
		contactRepo.deleteById(1L);
		assertThat(contactRepo.existsById(1L)).isFalse();
	}

}
