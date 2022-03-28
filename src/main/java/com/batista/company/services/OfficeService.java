package com.batista.company.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.batista.company.domain.Office;
import com.batista.company.dto.OfficeDTO;
import com.batista.company.repositories.OfficeRepository;

@Service
public class OfficeService {

	public static final BigDecimal MINIMUM_WAGE = new BigDecimal(1125);

	@Autowired
	private OfficeRepository officeRepository;

	public List<OfficeDTO> getAll() {
		List<Office> offices = officeRepository.findAll();
		return offices.stream().map(office -> new OfficeDTO(office)).collect(Collectors.toList());
	}

	public OfficeDTO getByName(String name) {
		String nameUpperCaseFirst = toUpperCaseFirst(name);
		Office office = officeRepository.findByName(nameUpperCaseFirst);
		OfficeDTO officeDTO = new OfficeDTO(office);
		return officeDTO;
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

		if (dto.getSalary().compareTo(MINIMUM_WAGE) <= 0) {
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

	public static String toUpperCaseFirst(String string) {

		if (isUpperCaseFirst(string) == true) {
			System.out.println("String is already Upper Case first");
		}

		char[] arr = string.toCharArray();
		arr[0] = Character.toUpperCase(arr[0]);
		return new String(arr);
	}

	public static boolean isUpperCaseFirst(String string) {
		if (0 == string.compareTo(string.toLowerCase())) {
			return false;
		} else {
			return true;
		}
	}

}
