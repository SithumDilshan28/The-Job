package com.example.job.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.job.model.job;

public interface jobRepo extends JpaRepository<job, Long>{


	@Query(value = "SELECT category, COUNT(*) as duplicateCount " +
            "FROM job " +
            "GROUP BY category " +
            "HAVING COUNT(*) >= 1", nativeQuery = true)
List<Object[]> findDistinctCategoriesWithDuplicateCount();

	@Query(value = "SELECT * FROM job ORDER BY RAND() LIMIT 1", nativeQuery = true)
	String getRandomJobTitle();

	 @Query(value = "SELECT * FROM job WHERE country = :country AND category = :category", nativeQuery = true)
	    List<job> findByCountryAndCategory(@Param("country") String country, @Param("category") String category);

	
}
