package com.ptwo.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ptwo.app.dao.CompanyDao;
import com.ptwo.app.model.Company;
import com.ptwo.app.service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {
	
	@Autowired
	private CompanyDao companyDao;

	@Override
	public Company createCompany(Company company) {
		// TODO Auto-generated method stub
		return companyDao.save(company);
	}

	@Override
	public Company updateCompany(Company company) {
		// TODO Auto-generated method stub
		return companyDao.save(company);
	}

	@Override
	public void deleteCompany(Long id) {
		// TODO Auto-generated method stub
		companyDao.deleteById(id);
		
	}

	@Override
	public List<Company> getAllCompany() {
		// TODO Auto-generated method stub
		return companyDao.findAll();
	}

	@Override
	public Company getCompanyById(Long id) {
		// TODO Auto-generated method stub
		return companyDao.findById(id).get();
	}


}
