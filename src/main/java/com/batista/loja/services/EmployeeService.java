package com.batista.loja.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.batista.loja.domain.Employee;
import com.batista.loja.repositories.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public List<Employee> getAll() {
		return employeeRepository.findAll();
	}

}
