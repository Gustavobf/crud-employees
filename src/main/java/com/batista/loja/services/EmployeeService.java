package com.batista.loja.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.batista.loja.domain.Employee;
import com.batista.loja.domain.Office;
import com.batista.loja.dto.EmployeeDTO;
import com.batista.loja.repositories.EmployeeRepository;
import com.batista.loja.repositories.OfficeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private OfficeRepository officeRepository;

	public List<EmployeeDTO> getAll() {

		List<Employee> employees = employeeRepository.findAll();
		return employees.stream().map(employee -> new EmployeeDTO(employee)).collect(Collectors.toList());
	}

	public EmployeeDTO getById(Long id) {
		Employee employee = employeeRepository.getById(id);
		EmployeeDTO employeeDTO = new EmployeeDTO(employee);
		return employeeDTO;
	}

	@Transactional
	public EmployeeDTO save(EmployeeDTO dto) {
		
		Integer nameLength = dto.getName().length();
		Boolean nameIsNull = dto.getName() == null;
		
		if (dto.getOfficeDTO() == null) {
			throw new RuntimeException("An Office is required.");
		}
		
		if (nameIsNull && (nameLength < 3 || nameLength > 50)) {
			throw new RuntimeException("Field Employee name length is not correct.");
		}
		
		if (dto.getAge() < 18) {
			throw new RuntimeException("Cannot be under 18.");
		}
		
		Office office = officeRepository.getById(dto.getOfficeDTO().getId());
		Employee employee = new Employee(null, dto.getName(), dto.getAge(), office);
		employee = employeeRepository.save(employee);
		EmployeeDTO employeeDTO = new EmployeeDTO(employee);
		return employeeDTO;
	}

	@Transactional
	public void delete(Long id) {
		employeeRepository.deleteById(id);
	}

	public EmployeeDTO update(Long id, EmployeeDTO dto) {
		Office office = officeRepository.getById(dto.getOfficeDTO().getId());
		Employee employee = new Employee(id, dto.getName(), dto.getAge(), office);
		employeeRepository.save(employee);
		EmployeeDTO employeeDTO = new EmployeeDTO(employee);
		return employeeDTO;

	}

}
