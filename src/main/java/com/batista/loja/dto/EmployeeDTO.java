package com.batista.loja.dto;

import com.batista.loja.domain.Employee;

public class EmployeeDTO {

	private Long id;
	private String name;
	private Integer age;

	private OfficeDTO officeDTO;

	public EmployeeDTO() {
	}

	public EmployeeDTO(Long id, String name, Integer age, OfficeDTO officeDTO) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.officeDTO = officeDTO;
	}

	public EmployeeDTO(Employee entity) {
		id = entity.getId();
		name = entity.getName();
		age = entity.getAge();
		officeDTO = new OfficeDTO(entity.getOffice());
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

	public OfficeDTO getOfficeDTO() {
		return officeDTO;
	}

	public void setOfficeDTO(OfficeDTO officeDTO) {
		this.officeDTO = officeDTO;
	}

}
