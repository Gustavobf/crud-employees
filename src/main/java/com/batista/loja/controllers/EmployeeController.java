package com.batista.loja.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
		return ResponseEntity.ok().body(list);
	}

}
