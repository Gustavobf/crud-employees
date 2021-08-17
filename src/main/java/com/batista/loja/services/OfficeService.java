package com.batista.loja.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.batista.loja.domain.Office;
import com.batista.loja.dto.OfficeDTO;
import com.batista.loja.repositories.OfficeRepository;

@Service
public class OfficeService {
	
	public static final BigDecimal MINIMUM_WAGE = new BigDecimal(1125);

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

	@Transactional
	public OfficeDTO save(OfficeDTO dto) {
		
		Integer nameLength = dto.getName().length();
		Boolean nameIsNull = dto.getName() == null;
		
		if (!nameIsNull && (nameLength < 3 || nameLength > 50)) {
			throw new RuntimeException("Field name length is not correct.");
		}
		
		if (dto.getSalary().compareTo(MINIMUM_WAGE) <= 0){
			throw new RuntimeException("Salary is not enough.");
		}
		
		Office office = new Office(null, dto.getName(), dto.getSalary());
		office = officeRepository.save(office);
		OfficeDTO officeDTO = new OfficeDTO(office);
		return officeDTO;
	}
	
	@Transactional
	public void delete(Long id) {
		officeRepository.deleteById(id);
	}
	
	public OfficeDTO update(Long id, OfficeDTO dto) {
		Office office = new Office(id, dto.getName(), dto.getSalary());
		officeRepository.save(office);
		OfficeDTO officeDTO = new OfficeDTO(office);
		return officeDTO;
		
	}
	
}
