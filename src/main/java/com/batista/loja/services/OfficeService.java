package com.batista.loja.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.batista.loja.domain.Office;
import com.batista.loja.repositories.OfficeRepository;

public class OfficeService {

	@Autowired
	private OfficeRepository officeRepository;

	public List<Office> getAll() {
		return officeRepository.findAll();
	}
}
