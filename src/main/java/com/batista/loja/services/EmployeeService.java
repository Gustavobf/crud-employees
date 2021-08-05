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

	public EmployeeDTO getById(Long id) {
		Employee employee = employeeRepository.getById(id);
		EmployeeDTO employeeDTO = new EmployeeDTO(employee);
		return employeeDTO;
	}

	public EmployeeDTO save(EmployeeDTO dto) {
		Employee employee = new Employee(null, dto.getName(), dto.getAge(), dto.getOffice());
		employee = employeeRepository.save(employee);
		EmployeeDTO employeeDTO = new EmployeeDTO(employee);
		return employeeDTO;
	}

	public void delete(Long id) {
		employeeRepository.deleteById(id);
	}

	public EmployeeDTO update(Long id, EmployeeDTO dto) {
		Employee employee = new Employee(id, dto.getName(), dto.getAge(), dto.getOffice());
		employeeRepository.save(employee);
		EmployeeDTO employeeDTO = new EmployeeDTO(employee);
		return employeeDTO;

	}

}
