package com.batista.company.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.batista.company.domain.Office;

@Repository
public interface OfficeRepository extends JpaRepository<Office, Long> {

	Office findByName(String name);
	
}
