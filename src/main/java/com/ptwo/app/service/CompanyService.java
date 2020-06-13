package com.ptwo.app.service;

import java.util.List;

import com.ptwo.app.model.Company;

public interface CompanyService {

	public Company createCompany(Company e);
	public Company updateCompany(Company c);
	public void deleteCompany(Long id);
	public List<Company> getAllCompany();
	public Company getCompanyById(Long id);
	public Company getCompanyByUserId(Long id);

}
