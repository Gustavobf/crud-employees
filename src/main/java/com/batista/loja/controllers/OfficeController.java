package com.batista.loja.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.batista.loja.dto.OfficeDTO;
import com.batista.loja.services.OfficeService;

@RestController
@RequestMapping(value = "/office")
public class OfficeController {

	@Autowired
	private OfficeService officeService;

	@GetMapping
	public ResponseEntity<List<OfficeDTO>> getAll() {
		List<OfficeDTO> list = officeService.getAll();
		return ResponseEntity.ok().body(list);
	}

	@PostMapping
	public ResponseEntity<OfficeDTO> save(@RequestBody OfficeDTO dto) {
		dto = officeService.save(dto);
		return ResponseEntity.ok().body(dto);

	}
}
