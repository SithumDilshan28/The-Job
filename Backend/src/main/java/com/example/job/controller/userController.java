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
import com.example.job.service.UserRepoService;

@CrossOrigin
@RestController
@RequestMapping("/user/")
public class userController {
    @Autowired
    private UserRepoService userRepoService;

    // Create User REST API
    @PostMapping("/saveuser")
    public user createUsers(@RequestBody user users) {
        return userRepoService.saveUser(users);
    }

    // Get All Users REST API
    @GetMapping("/getuser")
	private List<user> getAllUsers() {
        return userRepoService.findAllUsers();
    }

    // Get User By Id REST API
    @GetMapping("/getuser/{id}")
    public ResponseEntity<user> getUsersById(@PathVariable Long id) {
        user users = userRepoService.findUserById(id);
        if (users == null) {
            throw new ResourceNotFoundException("User not exist with id : " + id);
        }
        return ResponseEntity.ok(users);
    }

 // Update User REST API
    @PutMapping("/updateuser/{id}")
    public ResponseEntity<user> updateUsers(@PathVariable Long id, @RequestBody user dusers) {
        user users = userRepoService.findUserById(id);
        if (users == null) {
            throw new ResourceNotFoundException("User not exist with id : " + id);
        }
        // Update user attributes here
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
        users.setEducation(dusers.getEducation());
        users.setCollege(dusers.getCollege());
        users.setJob(dusers.getJob());
        users.setRole(dusers.getRole());

        user updatedUser = userRepoService.saveUser(users);
        return ResponseEntity.ok(updatedUser);
    }
    
    @GetMapping("/count")
    public long countAllUsers() {
        return userRepoService.countAllUsers();
    }

 // Delete User REST API
    @DeleteMapping("/deleteuser/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteUser(@PathVariable Long id) {
        userRepoService.deleteUser(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

    // Users Login
    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody user loginForm) {
        String email = loginForm.getEmail();
        String password = loginForm.getPassword();

        user user = userRepoService.findByEmailAndPassword(email, password);
        if (user != null) {
            // User authenticated successfully
            return com.example.job.response.response.responseBuilder("User Login Successfully.", HttpStatus.OK, user);
        } else {
            // Invalid credentials
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("message", "Request User Not Found");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse);
        }
		    }
    
    @GetMapping("/getuserbyemail/{email}")
    public ResponseEntity<user> getUsersByEmail(@PathVariable String email) {
        user users = userRepoService.findUserByEmail(email);
        if (users == null) {
            throw new ResourceNotFoundException("User not exist with email : " + email);
        }
        return ResponseEntity.ok(users);
    }

    @PutMapping("/updateuserbyemail/{email}")
    public ResponseEntity<user> updateUsersByEmail(@PathVariable String email, @RequestBody user dusers) {
        user users = userRepoService.findUserByEmail(email);
        if (users == null) {
            throw new ResourceNotFoundException("User not exist with email : " + email);
        }
        // Update user attributes here
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
        users.setEducation(dusers.getEducation());
        users.setCollege(dusers.getCollege());
        users.setJob(dusers.getJob());
        users.setRole(dusers.getRole());

        user updatedUser = userRepoService.saveUser(users);
        return ResponseEntity.ok(updatedUser);
    }

    
}
