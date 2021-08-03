package com.batista.loja.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.batista.loja.domain.Office;
import com.batista.loja.dto.OfficeDTO;
import com.batista.loja.repositories.OfficeRepository;

@Service
public class OfficeService {

	@Autowired
	private OfficeRepository officeRepository;

	public List<OfficeDTO> getAll() {
		List<Office> offices = officeRepository.findAll();
		return offices.stream().map(office -> new OfficeDTO(office)).collect(Collectors.toList());
	}
	
	public OfficeDTO getById(Long id) {
		Office office = officeRepository.getById(id);
		OfficeDTO officeDTO = new OfficeDTO(office);
		return officeDTO;
	}

	public OfficeDTO save(OfficeDTO dto) {
		Office office = new Office(null, dto.getName(), dto.getSalary());
		office = officeRepository.save(office);
		return new OfficeDTO(office);
	}
}
