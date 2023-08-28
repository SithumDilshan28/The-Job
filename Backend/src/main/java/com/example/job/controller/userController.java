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
import com.example.job.model.user;
import com.example.job.repository.userRepo;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/user/")
public class userController {
	
	@Autowired
	private userRepo usersRepository;

	// create users REST API
		@PostMapping("/saveusers")
		public user createUsers(@RequestBody user users) {
			return usersRepository.save(users);
		}
		
		// get all Users REST API
		@GetMapping("/getusers")
		private List<user> getAllUsers() {
			return usersRepository.findAll();
		}
		
		// get User by Id REST API
		@GetMapping("/getusers/{id}")
		public ResponseEntity<user> getUsersById(@PathVariable Long id) {
			user users = usersRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("User not exist with id : " + id));
			return ResponseEntity.ok(users);
		}
		
		// update User REST API
		@PutMapping("/getusers/{id}")
		public ResponseEntity<user> updateUsers(@PathVariable Long id, @RequestBody user dusers) {
			user users = usersRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("User not exist with id : " + id));
			users.setFirstname(dusers.getFirstname());
			users.setLastname(dusers.getLastname());
			users.setNic(dusers.getNic());
			users.setDob(dusers.getDob());
			users.setSex(dusers.getSex());
			users.setMaritalStatus(dusers.getMaritalStatus());
			users.setAddress(dusers.getAddress());
			users.setPhone(dusers.getPhone());
			users.setEmail(dusers.getEmail());
			users.setPassword(dusers.getPassword());
			users.setCollege(dusers.getCollege());
			users.setJob(dusers.getRole());
			users.setRole(dusers.getRole());

			user updateUsers = usersRepository.save(users);
			return ResponseEntity.ok(updateUsers);
		}

		// delete User REST API
		@DeleteMapping("/getusers/{id}")
		public ResponseEntity<Map<String, Boolean>> deleteUser(@PathVariable Long id) {
			user users = usersRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("User not exist with id : " + id));

			usersRepository.delete(users);
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return ResponseEntity.ok(response);
		}
		
		//Users Login
		 @PostMapping("/login")
		    public ResponseEntity<Object> login(@RequestBody user loginForm) {
		        String email = loginForm.getEmail();
		        String password = loginForm.getPassword();

		        user user = usersRepository.findByEmailAndPassword(email, password);
		        if (user != null) {
		            // User authenticated successfully
		        	return com.example.job.response.response.responseBuilder("User Login Successfully.", HttpStatus.OK, usersRepository.findByEmailAndPassword(email, password));
		        	
		        } else {
		            // Invalid credentials
		        	Map<String, String> errorResponse = new HashMap<>();
		            errorResponse.put("message", "Request User Not Found");
		            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse);
		        }
		    }
}
