package com.example.job.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.job.exception.ResourceNotFoundException;
import com.example.job.model.appointment;
import com.example.job.repository.appointmentRepo;


@CrossOrigin
@RestController
@RequestMapping("/appointment/")
public class appointmentController {
	@Autowired
	private appointmentRepo appoinmentRepo;
		
		// Create Appointment REST API
		@PostMapping("/saveappoinment")
		public appointment createAppointments(@RequestBody appointment appoinment) {
			return appoinmentRepo.save(appoinment);
		}

		// Get All Appointment REST API
		@GetMapping("/getappointment")
		private List<appointment> getAllAppointment() {
			return appoinmentRepo.findAll();
		}
		
		// Delete Appointment REST API
		@DeleteMapping("/deleteappoitment/{id}")
		public ResponseEntity<Map<String, Boolean>> deleteAppointment(@PathVariable Long id) {
			appointment appoinment = appoinmentRepo.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("appoinment not exist with id : " + id));

			appoinmentRepo.delete(appoinment);
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return ResponseEntity.ok(response);
		}
}
