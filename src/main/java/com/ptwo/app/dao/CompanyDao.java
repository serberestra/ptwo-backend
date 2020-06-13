package com.ptwo.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.ptwo.app.model.Company;

@Repository
public interface CompanyDao extends JpaRepository<Company, Long> {
	public Company findByUserId(Long id);
}
