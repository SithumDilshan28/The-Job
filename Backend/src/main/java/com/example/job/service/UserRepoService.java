package com.example.job.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import com.example.job.model.user;
import com.example.job.repository.userRepo;

@Service
public class UserRepoService {

    private static UserRepoService instance; // Singleton instance
    
    @Autowired
    private userRepo userRepository;

    private UserRepoService() {
        
    }

    public static UserRepoService getInstance() {
        if (instance == null) {
            synchronized (UserRepoService.class) {
                if (instance == null) {
                    instance = new UserRepoService();
                }
            }
        }
        return instance;
    }

    public user saveUser(user user) {
        return userRepository.save(user);
    }

    public List<user> findAllUsers() {
        return userRepository.findAll();
    }

    public user findUserById(Long id) {
        Optional<user> userOptional = userRepository.findById(id);
        return userOptional.orElse(null);
    }

    public user updateUser(Long id, user updatedUser) {
        Optional<user> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            user existingUser = userOptional.get();
            // Update user attributes here
            existingUser.setFirstname(updatedUser.getFirstname());
            existingUser.setLastname(updatedUser.getLastname());
            existingUser.setNic(updatedUser.getNic());
            existingUser.setDob(updatedUser.getDob());
            existingUser.setSex(updatedUser.getSex());
            existingUser.setMaritalStatus(updatedUser.getMaritalStatus());
            existingUser.setAddress(updatedUser.getAddress());
            existingUser.setPhone(updatedUser.getPhone());
            existingUser.setEmail(updatedUser.getEmail());
            existingUser.setPassword(updatedUser.getPassword());
            existingUser.setEducation(updatedUser.getEducation());
            existingUser.setCollege(updatedUser.getCollege());
            existingUser.setJob(updatedUser.getJob());
            existingUser.setRole(updatedUser.getRole());
            return userRepository.save(existingUser);
        } else {
            return null; // User not found
        }
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Query(value = "SELECT * FROM user WHERE email = :email AND password = :password", nativeQuery = true)
    public user findByEmailAndPassword(@Param("email") String name, @Param("password") String password) {
        return userRepository.findByEmailAndPassword(name, password);
    }
    
    @Query(value = "SELECT COUNT(*) FROM user", nativeQuery = true)
    public long countAllUsers() {
        return userRepository.countAllUsers();
    }
    
    
    public user findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public user updateByEmail(String email, user updatedUser) {
        user users = userRepository.findByEmail(email);
        if (users != null) {
            // Update user attributes here
            users.setFirstname(updatedUser.getFirstname());
            users.setLastname(updatedUser.getLastname());
            users.setNic(updatedUser.getNic());
            users.setDob(updatedUser.getDob());
            users.setSex(updatedUser.getSex());
            users.setMaritalStatus(updatedUser.getMaritalStatus());
            users.setAddress(updatedUser.getAddress());
            users.setPhone(updatedUser.getPhone());
            users.setEmail(updatedUser.getEmail());
            users.setPassword(updatedUser.getPassword());
            users.setEducation(updatedUser.getEducation());
            users.setCollege(updatedUser.getCollege());
            users.setJob(updatedUser.getJob());
            users.setRole(updatedUser.getRole());
            return userRepository.save(users);
        } else {
            return null; // User not found
        }
    }
    
    
}
