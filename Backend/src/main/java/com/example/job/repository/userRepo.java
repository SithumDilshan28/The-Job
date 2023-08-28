package com.example.job.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.job.model.user;

public interface userRepo extends JpaRepository<user, Long> {
	 @Query(value = "SELECT * FROM user WHERE email = :email AND password = :password", nativeQuery = true)
	    user findByEmailAndPassword(@Param("email") String name, @Param("password") String password);
}
