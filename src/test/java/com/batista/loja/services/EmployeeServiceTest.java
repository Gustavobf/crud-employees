package com.batista.loja.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.batista.loja.domain.Employee;
import com.batista.loja.domain.Office;
import com.batista.loja.dto.EmployeeDTO;
import com.batista.loja.dto.OfficeDTO;
import com.batista.loja.repositories.EmployeeRepository;
import com.batista.loja.repositories.OfficeRepository;

@SpringBootTest
public class EmployeeServiceTest {

	@InjectMocks
	EmployeeService employeeServiceTest;

	@Mock
	OfficeRepository officeRepository;

	@Mock
	EmployeeRepository employeeRepository;

	@Test
	public void saveMethodTest() {

		Office officeTest = new Office(1L, "OfficeEmployeeTest", new BigDecimal(1250));

		Mockito.when(employeeRepository.save(Mockito.any(Employee.class)))
				.thenReturn(new Employee(1l, "EmployeeTest", 19, officeTest));

		OfficeDTO officeDTO = new OfficeDTO(officeTest);
		EmployeeDTO employeeDTO = new EmployeeDTO();
		employeeDTO.setName("EmployeeTest");
		employeeDTO.setAge(19);
		employeeDTO.setOfficeDTO(officeDTO);

		EmployeeDTO returnedDTO = employeeServiceTest.save(employeeDTO);

		assertEquals("EmployeeTest", returnedDTO.getName());
		assertEquals(19, returnedDTO.getAge());
		assertThat(officeDTO).usingRecursiveComparison().isEqualTo(returnedDTO.getOfficeDTO());

	}

}
