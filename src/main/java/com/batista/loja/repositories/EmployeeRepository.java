package com.batista.loja.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.batista.loja.domain.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
