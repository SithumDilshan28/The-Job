package com.example.job.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.job.model.job;

public interface jobRepo extends JpaRepository<job, Long>{


	@Query(value = "SELECT DISTINCT category FROM job", nativeQuery = true)
	List<String> findDistinctCategories();
	
	@Query(value = "SELECT category, COUNT(*) as duplicateCount FROM job GROUP BY category", nativeQuery = true)
    List<Object[]> findDistinctCategoriesWithDuplicateCount();
	
}
