package com.ptwo.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ptwo.app.model.Company;
import com.ptwo.app.service.CompanyService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class CompanyController {
	
	@Autowired
	private CompanyService service;
	
	@PostMapping("/company")
	public Company createCompany(@RequestBody Company company) {
		// TODO Auto-generated method stub
		return service.createCompany(company);
	}

	@PutMapping("/company")
	public Company updateCompany(@RequestBody Company company) {
		// TODO Auto-generated method stub
		return service.updateCompany(company);
	}

	@DeleteMapping("/company/{id}")
	public void deleteCompany(@PathVariable Long id) {
		// TODO Auto-generated method stub
		service.deleteCompany(id);
		
	}

	@GetMapping("/companies")
	public List<Company> getAllCompany() {
		// TODO Auto-generated method stub
		return service.getAllCompany();
	}

	@GetMapping("/company/{id}")
	public Company getCompanyById(@PathVariable Long id) {
		// TODO Auto-generated method stub
		return service.getCompanyById(id);
	}
	@GetMapping("/company/user/{id}")
	public Company getCompanyByUid(@PathVariable Long id) {
		return service.getCompanyByUserId(id);
	}

}
