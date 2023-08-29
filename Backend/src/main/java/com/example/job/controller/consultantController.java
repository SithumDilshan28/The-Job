package com.example.job.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.job.exception.ResourceNotFoundException;
import com.example.job.model.consultant;
import com.example.job.repository.consultantRepo;
import com.example.job.response.response;


@CrossOrigin
@RestController
@RequestMapping("/consultant/")
public class consultantController {
	
	@Autowired
	private consultantRepo consultantRepository;
	

		// Create Consultant REST API
		@PostMapping("/saveconsultants")
		public consultant createConsultants(@RequestBody consultant consultants) {
			return consultantRepository.save(consultants);
		}
		
		// Get All Consultant REST API
		@GetMapping("/getconsultant")
		private List<consultant> getAllConsult() {
			return consultantRepository.findAll();
		}

		// Get Consultant By Id REST API
		@GetMapping("/getconsultant/{id}")
		public ResponseEntity<consultant> getconsultById(@PathVariable Long id) {
			consultant consult = consultantRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Consult not exist with id : " + id));
			return ResponseEntity.ok(consult);
		}

		// Update Consultant REST API
		@PutMapping("/updateconsultant/{id}")
		public ResponseEntity<consultant> updateConsult(@PathVariable Long id, @RequestBody consultant consult) {
			consultant consult2 = consultantRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Consult not exist with id : " + id));
			consult2.setFullname(consult.getFullname());
			consult2.setEmail(consult.getEmail());
			consult2.setPassword(consult.getPassword());
			consult2.setNic(consult.getNic());
			consult2.setPhone(consult.getPhone());
			consult2.setAddress(consult.getAddress());
			consult2.setSpecilizedcountry(consult.getSpecilizedcountry());
			consult2.setSpecilizedjobtype(consult.getSpecilizedjobtype());
			consult2.setImageurl(consult.getImageurl());

			consultant updateConsult = consultantRepository.save(consult2);
			return ResponseEntity.ok(updateConsult);
		}

		// delete Consultant REST API
		@DeleteMapping("/deleteconsultant/{id}")
		public ResponseEntity<Map<String, Boolean>> deleteConsult(@PathVariable Long id) {
			consultant consult = consultantRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Consult not exist with id : " + id));

			consultantRepository.delete(consult);
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return ResponseEntity.ok(response);
		}

		// Consultant Login
		@PostMapping("/login")
		public ResponseEntity<Object> login(@RequestBody consultant loginForm) {
			String email = loginForm.getEmail();
			String password = loginForm.getPassword();

			consultant consults = consultantRepository.findByEmailAndPassword(email, password);
			if (consults != null) {
				// User authenticated successfully
				return response.responseBuilder("Consult Login Successfully.", HttpStatus.OK,
						consultantRepository.findByEmailAndPassword(email, password));

			} else {
				// Invalid credentials
				Map<String, String> errorResponse = new HashMap<>();
				errorResponse.put("message", "Request Consult Not Found");
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse);
			}
		}
		
		
}
