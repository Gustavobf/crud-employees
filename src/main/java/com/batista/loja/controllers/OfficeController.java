package com.batista.loja.controllers;

import java.util.List;

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

	@GetMapping("/{id}")
	public ResponseEntity<OfficeDTO> getById(@PathVariable Long id) {
		OfficeDTO officeDTO = officeService.getById(id);
		return ResponseEntity.ok().body(officeDTO);
	}

	@PostMapping
	public ResponseEntity<OfficeDTO> save(@RequestBody OfficeDTO officeDTO) {
		officeDTO = officeService.save(officeDTO);
		return ResponseEntity.ok().body(officeDTO);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		officeService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<OfficeDTO> update(@PathVariable Long id, @RequestBody OfficeDTO dto) {
		OfficeDTO officeDTO = officeService.update(id, dto);
		return ResponseEntity.ok().body(officeDTO);
	}
	
}
