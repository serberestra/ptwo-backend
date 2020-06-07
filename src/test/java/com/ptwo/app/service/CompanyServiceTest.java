package com.ptwo.app.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ptwo.app.dao.CompanyDao;
import com.ptwo.app.model.Company;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CompanyServiceTest {
	
	@Autowired
	CompanyService companyService;
	
    @Before
    public void setUp() throws Exception {
        // Clean up the test db
        List<Company> cList = companyService.getAllCompany();
        for (Company c : cList) {
            companyService.deleteCompany(c.getId());
        }

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

//        companyService.deleteCompany(company.getId());
//        Long id = company.getId();
//        Company company3 = companyService.getCompanyById(id);
//        assertNull(company3);
		
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

        company = new Company();
		company.setName("Buy More");
		company.setAddress("300 Bronze St");
		company.setPhoneNumber("(777)235");
        companyService.createCompany(company);

        //assertEquals(2, cList.size());

        // Delete "Buy More";
        companyService.deleteCompany(company.getId());

        List<Company> cList = companyService.getAllCompany();

        assertEquals(1, cList.size());
        
//        Company company1 = companyService.getCompanyById(company.getId());
//        assertNull(company1); 
        
	}

	@Test
	public void testGetAllCompany() {
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

        List<Company> cList = companyService.getAllCompany();

        assertEquals(2, cList.size());
	}


}
