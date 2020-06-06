package com.ptwo.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.ptwo.app.model.Company;

@Service
public interface CompanyDao extends JpaRepository<Company, Long> {

}
