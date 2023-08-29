package com.example.job.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.job.model.consultant;

public interface consultantRepo extends JpaRepository<consultant, Long> {
	
	@Query(value = "SELECT * FROM consultant WHERE email = :email AND password = :password", nativeQuery = true)
    consultant findByEmailAndPassword(@Param("email") String name, @Param("password") String password);
}
