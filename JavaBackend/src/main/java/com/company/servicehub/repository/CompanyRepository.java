package com.company.servicehub.repository;

import com.company.servicehub.model.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class CompanyRepository {
	
	@Autowired
	EntityManager em;

	public Company findById(Long id){
		return em.find(Company.class, id);
	}


//	public Company save(Company company) {
//		return company;
//	}
	

}
