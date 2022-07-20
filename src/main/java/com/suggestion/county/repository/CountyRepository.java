package com.suggestion.county.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.suggestion.county.entity.CountyEntity;

@Repository
public interface CountyRepository extends JpaRepository<CountyEntity, Long> {

	@Query("SELECT c FROM CountyEntity c where lower(c.state) like lower(concat(:query,'%')) "
			+ "or lower(c.name) like lower(concat(:query,'%')) order by c.name")
	Page<CountyEntity> findByNameOrStateIgnoreCase(@Param("query") String query, Pageable pageable);

}
