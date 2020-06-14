package com.ptwo.app.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ptwo.app.dao.CompanyDao;
import com.ptwo.app.model.Company;
import com.ptwo.app.service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {
	
	@Autowired
	private CompanyDao companyDao;

	@Override
	@Transactional
	public Company createCompany(Company company) {
		try {
			return companyDao.save(company);
		} catch (DataIntegrityViolationException e) {
			return null;
		}

	}

	@Override
	public Company updateCompany(Company company) {
		try {
			return companyDao.save(company);
		} catch (DataIntegrityViolationException e) {
			return null;
		}
	}

	@Override
	@Transactional
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
		try {
            return companyDao.findById(id).get();
        } catch (NoSuchElementException e) {
            // if there is no Company with this id, just return null
            return null;
        }
	}

	@Override
	public Company getCompanyByUserId(Long id) {
		// TODO Auto-generated method stub
		try {
			return companyDao.findByUserId(id);
		}catch (NoSuchElementException e) {
			return null;	
		}
	}
	


}
