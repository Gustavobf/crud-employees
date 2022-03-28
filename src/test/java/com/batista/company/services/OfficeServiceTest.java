package com.batista.company.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.batista.company.domain.Office;
import com.batista.company.dto.OfficeDTO;
import com.batista.company.repositories.OfficeRepository;
import com.batista.company.services.OfficeService;

@SpringBootTest
public class OfficeServiceTest {

	@InjectMocks
	OfficeService officeServiceMock;

	@Mock
	OfficeRepository officeRepository;

	@Test
	public void saveMethodTest() {
		
		//New Office
		Mockito.when(officeRepository.save(Mockito.any(Office.class)))
				.thenReturn(new Office(1L, "TestOffice", new BigDecimal(2000)));

		//Domain to DTO 
		OfficeDTO officeDTO = new OfficeDTO();
		officeDTO.setName("TestOffice");
		officeDTO.setSalary(new BigDecimal(2000));
		
		//Save method
		OfficeDTO returnedDTO = officeServiceMock.save(officeDTO);
		
		//Asserting equals
		assertEquals(1L, returnedDTO.getId());
		assertEquals("TestOffice", returnedDTO.getName());
		assertEquals(new BigDecimal(2000), returnedDTO.getSalary());
	}

}
