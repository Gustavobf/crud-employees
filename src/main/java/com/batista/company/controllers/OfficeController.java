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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.batista.company.dto.OfficeDTO;
import com.batista.company.services.OfficeService;

@RestController
@RequestMapping(value = "/api/offices")
public class OfficeController {

	@Autowired
	private OfficeService officeService;

	@ApiOperation("Returns a list of offices")
	@GetMapping
	public ResponseEntity<List<OfficeDTO>> getAll() {
		final List<OfficeDTO> list = officeService.getAll();
		return ResponseEntity.status(200).body(list);
	}
	@ApiOperation("Returns an office based on its id")
	@GetMapping("/{id}")
	public ResponseEntity<OfficeDTO> getById(@PathVariable final Long id) {
		final OfficeDTO officeDTO = officeService.getById(id);
		return ResponseEntity.status(200).body(officeDTO);
	}

	@ApiOperation("Returns an office based on its name")
	@GetMapping("/findByName")
	public ResponseEntity<OfficeDTO> getByName(@RequestParam("name") final String name) {
		final OfficeDTO officeDTO = officeService.getByName(name);
		return ResponseEntity.status(200).body(officeDTO);
	}

	@ApiOperation("Saves an office")
	@PostMapping
	public ResponseEntity<OfficeDTO> save(@Valid @RequestBody OfficeDTO officeDTO) {
		officeDTO = officeService.save(officeDTO);
		return ResponseEntity.status(201).body(officeDTO);
	}

	@ApiOperation("Deletes an office based on its id")
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable final Long id) {
		officeService.delete(id);
		return ResponseEntity.status(204).build();
	}

	@ApiOperation("Updates an office based on its id")
	@PutMapping("/{id}")
	public ResponseEntity<OfficeDTO> update(@PathVariable final Long id, @Valid @RequestBody final OfficeDTO dto) {
		final OfficeDTO officeDTO = officeService.update(id, dto);
		return ResponseEntity.status(200).body(officeDTO);
	}

}
