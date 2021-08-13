package com.batista.loja.controllers;

import java.util.List;

import javax.validation.Valid;

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

import com.batista.loja.dto.EmployeeDTO;
import com.batista.loja.services.EmployeeService;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping
	public ResponseEntity<List<EmployeeDTO>> getAll() {
		List<EmployeeDTO> list = employeeService.getAll();
		return ResponseEntity.status(200).body(list);
	}

	@GetMapping("/{id}")
	public ResponseEntity<EmployeeDTO> getById(@PathVariable Long id) {
		EmployeeDTO employeeDTO = employeeService.getById(id);
		return ResponseEntity.status(200).body(employeeDTO);
	}

	@PostMapping
	public ResponseEntity<EmployeeDTO> save(@Valid @RequestBody EmployeeDTO employeeDTO) {
		employeeDTO = employeeService.save(employeeDTO);
		return ResponseEntity.status(201).body(employeeDTO);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		employeeService.delete(id);
		return ResponseEntity.status(204).build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<EmployeeDTO> update(@PathVariable Long id, @Valid @RequestBody EmployeeDTO dto) {
		EmployeeDTO employeeDTO = employeeService.update(id, dto);
		return ResponseEntity.status(200).body(employeeDTO);
	}

}
