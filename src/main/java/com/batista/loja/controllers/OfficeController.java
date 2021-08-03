package com.batista.loja.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.batista.loja.domain.Office;
import com.batista.loja.services.OfficeService;

@RestController
public class OfficeController {
	@Autowired
	private OfficeService officeServices;

	@GetMapping
	public ResponseEntity<List<Office>> getAll() {
		List<Office> list = officeServices.getAll();
		return ResponseEntity.ok().body(list);
	}
}
