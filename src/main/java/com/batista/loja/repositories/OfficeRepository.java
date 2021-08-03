package com.batista.loja.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.batista.loja.domain.Office;

@Repository
public interface OfficeRepository extends JpaRepository<Office, Long> {

}
