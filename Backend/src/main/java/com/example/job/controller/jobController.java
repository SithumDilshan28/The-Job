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
import com.example.job.model.job;
import com.example.job.repository.jobRepo;


@CrossOrigin
@RestController
@RequestMapping("/job/")
public class jobController {
	
	@Autowired
	private jobRepo jobsRepository;

		// Create Job REST API
		@PostMapping("/savejob")
		public job createJobs(@RequestBody job jobs) {
			return jobsRepository.save(jobs);
		}
		
		// Get All Job REST API
		@GetMapping("/getjob")
		private List<job> getAllJobs() {
			return jobsRepository.findAll();
		}
		
		// Get Job By Id REST API
		@GetMapping("/getjob/{id}")
		public ResponseEntity<job> getJobssById(@PathVariable Long id) {
			job jobs = jobsRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Job not exist with id : " + id));
			return ResponseEntity.ok(jobs);
		}
		
		// Update Job REST API
				@PutMapping("/updatejob/{id}")
				public ResponseEntity<job> updateUsers(@PathVariable Long id, @RequestBody job gjob) {
					job sjob = jobsRepository.findById(id)
							.orElseThrow(() -> new ResourceNotFoundException("Job not exist with id : " + id));
					sjob.setRole(gjob.getRole());
					sjob.setCompany(gjob.getCompany());
					sjob.setExperience(gjob.getExperience());
					sjob.setCountry(gjob.getCountry());
					sjob.setSalary(gjob.getSalary());
					sjob.setCategory(gjob.getCategory());
					sjob.setType(gjob.getType());
					sjob.setStatus(gjob.getStatus());
					sjob.setImageurl(gjob.getImageurl());

					job updatejobs = jobsRepository.save(sjob);
					return ResponseEntity.ok(updatejobs);
				}
				
		// Delete User REST API
				@DeleteMapping("/deletejob/{id}")
				public ResponseEntity<Map<String, Boolean>> deleteJob(@PathVariable Long id) {
					job jobs = jobsRepository.findById(id)
							.orElseThrow(() -> new ResourceNotFoundException("Job not exist with id : " + id));

					jobsRepository.delete(jobs);
					Map<String, Boolean> response = new HashMap<>();
					response.put("deleted", Boolean.TRUE);
					return ResponseEntity.ok(response);
				}

				@PostMapping("/getcategories")
				public List<String> getDistinctCategories() {
			        return jobsRepository.findDistinctCategories();
			    }

}
