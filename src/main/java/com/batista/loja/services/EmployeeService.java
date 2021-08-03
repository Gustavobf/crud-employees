package com.batista.loja.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.batista.loja.domain.Employee;
import com.batista.loja.dto.EmployeeDTO;
import com.batista.loja.repositories.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public List<EmployeeDTO> getAll() {

		List<Employee> employees = employeeRepository.findAll();
		return employees.stream().map(employee -> new EmployeeDTO(employee)).collect(Collectors.toList());
	}

}
