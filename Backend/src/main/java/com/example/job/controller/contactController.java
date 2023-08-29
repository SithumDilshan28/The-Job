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
import com.example.job.model.contact;
import com.example.job.repository.contactRepo;

@CrossOrigin
@RestController
@RequestMapping("/contact/")
public class contactController {
	
	@Autowired
	private contactRepo contactRepo;
		
		// Create Contact REST API
		@PostMapping("/savecontact")
		public contact createContacts(@RequestBody contact contact) {
			return contactRepo.save(contact);
		}

		// Get All Contact REST API
		@GetMapping("/getcontact")
		private List<contact> getAllContact() {
			return contactRepo.findAll();
		}
		
		// Delete Contact REST API
		@DeleteMapping("/deletecontact/{id}")
		public ResponseEntity<Map<String, Boolean>> deletecontact(@PathVariable Long id) {
			contact contact = contactRepo.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Contact not exist with id : " + id));

			contactRepo.delete(contact);
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return ResponseEntity.ok(response);
		}

}
