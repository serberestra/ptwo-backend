package com.ptwo.app.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ptwo.app.model.Company;

@SpringBootTest
public class CompanyServiceTest {
	
	@Autowired
	private CompanyService companyService;
	
    @BeforeAll
    static void setUp() throws Exception {
    	System.out.println("Testing Company Services.");
    }
    
    @Test
	public void contextLoads() throws Exception {
		assertThat(companyService).isNotNull();
	}
	
	@Test
	public void testCreateGetCompany() {
		
		Company company = new Company();
		company.setName("XYZ Electronics");
		company.setAddress("150 Silver St");
		company.setPhoneNumber("(565)345");
		
		companyService.createCompany(company);
		
		Company company1 = companyService.getCompanyById(company.getId());
		
        assertEquals(company1, company);

        companyService.deleteCompany(company.getId());
        company1 = companyService.getCompanyById(company.getId());
        assertThat(company1).isNull();
		
	}

	@Test
	public void testUpdateCompany() {
        Company company = new Company();
		company.setName("XYZ Electronics");
		company.setAddress("150 Silver St");
		company.setPhoneNumber("(565)345");
		
		companyService.createCompany(company);

        company.setName("XYZ Electronics, Inc");
        company.setAddress("150 Diamond St");
        companyService.updateCompany(company);

        Company company1 = companyService.getCompanyById(company.getId());

        assertEquals("XYZ Electronics, Inc", company1.getName());
        assertEquals("150 Diamond St", company1.getAddress());

	}

	@Test
	public void testDeleteCompany() {
        Company company = new Company();
		company.setName("XYZ Electronics");
		company.setAddress("150 Silver St");
		company.setPhoneNumber("(565)345");
        companyService.createCompany(company);

        // Delete "Buy More";
        companyService.deleteCompany(company.getId());
        
        Company company1 = companyService.getCompanyById(company.getId());
        assertThat(company1).isNull(); 
	}

	@Test
	public void testGetAllCompany() {
		
		List<Company> cList = companyService.getAllCompany();
        for (Company c : cList) {
        	companyService.deleteCompany(c.getId());
        }
		
        Company company = new Company();
		company.setName("XYZ Electronics");
		company.setAddress("150 Silver St");
		company.setPhoneNumber("(565)345");
        companyService.createCompany(company);

        company = new Company();
		company.setName("Buy More");
		company.setAddress("300 Bronze St");
		company.setPhoneNumber("(777)235");
        companyService.createCompany(company);

        cList = companyService.getAllCompany();
        assertEquals(2, cList.size());
	}


}
