package com.batista.company.controllers;

import java.util.List;

import javax.validation.Valid;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.batista.company.dto.EmployeeDTO;
import com.batista.company.services.EmployeeService;

@RestController
@RequestMapping(value = "/api/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@ApiOperation("Returns a list with all employees")
	@GetMapping
	public ResponseEntity<List<EmployeeDTO>> getAll() {
		final List<EmployeeDTO> list = employeeService.getAll();
		return ResponseEntity.status(200).body(list);
	}

	@ApiOperation("Returns an employee based on its id")
	@GetMapping("/{id}")
	public ResponseEntity<EmployeeDTO> getById(@PathVariable final Long id) {
		final EmployeeDTO employeeDTO = employeeService.getById(id);
		return ResponseEntity.status(200).body(employeeDTO);
	}

	@ApiOperation("Saves an employee")
	@PostMapping
	public ResponseEntity<EmployeeDTO> save(@Valid @RequestBody EmployeeDTO employeeDTO) {
		employeeDTO = employeeService.save(employeeDTO);
		return ResponseEntity.status(201).body(employeeDTO);
	}

	@ApiOperation("Deletes an employee based on its id")
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable final Long id) {
		employeeService.delete(id);
		return ResponseEntity.status(204).build();
	}

	@ApiOperation("Updates an employee based on its id")
	@PutMapping("/{id}")
	public ResponseEntity<EmployeeDTO> update(@PathVariable final Long id, @Valid @RequestBody final EmployeeDTO dto) {
		final EmployeeDTO employeeDTO = employeeService.update(id, dto);
		return ResponseEntity.status(200).body(employeeDTO);
	}

}
