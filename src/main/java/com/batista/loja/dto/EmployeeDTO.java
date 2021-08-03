package com.batista.loja.dto;

import com.batista.loja.domain.Employee;
import com.batista.loja.domain.Office;

public class EmployeeDTO {

	private Long id;
	private String name;
	private Integer age;

	private Office office;

	public EmployeeDTO() {
	}

	public EmployeeDTO(Long id, String name, Integer age, Office office) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.office = office;
	}

	public EmployeeDTO(Employee entity) {
		id = entity.getId();
		name = entity.getName();
		age = entity.getAge();
//		office = new OfficeDTO();
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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Office getOffice() {
		return office;
	}

	public void setOffice(Office office) {
		this.office = office;
	}

}
