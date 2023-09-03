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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.job.exception.ResourceNotFoundException;
import com.example.job.model.availability;
import com.example.job.repository.availabilityRepo;



@CrossOrigin
@RestController
@RequestMapping("/availability/")
public class availabilityController {
	
	@Autowired
	private availabilityRepo availabilityRepository;

		// Create Availability REST API
		@PostMapping("/saveavailability")
		public availability createAvailability(@RequestBody availability availabilities) {
			return availabilityRepository.save(availabilities);
		}
		
		// Get All Availability REST API
		@GetMapping("/getavailability")
		private List<availability> getAllAvailability() {
			return availabilityRepository.findAll();
		}
		
		// Get Availability By Id REST API
		@GetMapping("/getAvailability/{id}")
		public ResponseEntity<availability> getAvalabilityById(@PathVariable Long id) {
			availability availabilities = availabilityRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Availability not exist with id : " + id));
			return ResponseEntity.ok(availabilities);
		}
		
		// Update Availability REST API
		@PutMapping("/updateavailability/{id}")
		public ResponseEntity<availability> updateAvailability(@PathVariable Long id, @RequestBody availability gAvailability) {
			availability sAvailability = availabilityRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("User not exist with id : " + id));
			sAvailability.setDate(gAvailability.getDate());
			sAvailability.setTimeslot(gAvailability.getTimeslot());
			

			availability updateAvailability = availabilityRepository.save(sAvailability);
			return ResponseEntity.ok(updateAvailability);
		}

		// Delete Availability REST API
		@DeleteMapping("/deleteavailability/{id}")
		public ResponseEntity<Map<String, Boolean>> deleteAvailability(@PathVariable Long id) {
			availability availabilities = availabilityRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("User not exist with id : " + id));

			availabilityRepository.delete(availabilities);
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return ResponseEntity.ok(response);
		}
		
		 @PostMapping("/search")
		    public List<availability> getAvailabilityByDateAndTimeslotPost(
		            @RequestBody availability searchRequest) {
		        String date = searchRequest.getDate();
		        String timeslot = searchRequest.getTimeslot();
		        return availabilityRepository.findByDateAndTimeslot(date, timeslot);
		    }
}
