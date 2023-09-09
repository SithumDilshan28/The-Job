package com.example.job;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.job.model.appointment;

@SpringBootTest
public class AppointmentControllerTest {
	
	@Autowired
	com.example.job.repository.appointmentRepo appointmentRepo;

	@Test
	public void testAppointmentSave() {
		appointment appoinment = new appointment();
		appoinment.setId(2L);
		appoinment.setConsultantname("shanu");
		appoinment.setClientname("zaggy");
		appoinment.setEmail("shanuzaggy@gmail.com");
		appoinment.setDate("08-09-2023");
		appoinment.setTime("10:00 AM - 11:00 AM");
		appoinment.setClientphone("078824265");
		appointmentRepo.save(appoinment);
		assertNotNull(appointmentRepo.findById(2L).get());
	}
	
	@Test
	public void testReadAllAppointment() {
		List<appointment> list1 = appointmentRepo.findAll();
		assertThat(list1).size().isGreaterThan(0);
	}
	
	@Test
	public void testDeleteAppointment() {
		appointmentRepo.deleteById(1L);
		assertThat(appointmentRepo.existsById(1L)).isFalse();
	}

}
