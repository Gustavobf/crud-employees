package com.batista.company.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.batista.company.domain.Employee;
import com.fasterxml.jackson.annotation.JsonProperty;

public class EmployeeDTO {

	private Long id;

	@NotEmpty
	private String name;

	@NotNull
	private Integer age;

	@JsonProperty("office")
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
