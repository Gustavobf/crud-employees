package com.batista.loja.dto;

import java.math.BigDecimal;

import com.batista.loja.domain.Office;

public class OfficeDTO {

	private Long id;
	private String name;
	private BigDecimal salary;

	public OfficeDTO() {
	}

	public OfficeDTO(Long id, String name, BigDecimal salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	public OfficeDTO(Office entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.salary = entity.getSalary();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

}
