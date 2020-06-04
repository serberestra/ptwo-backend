package com.company.servicehub.repository;

import com.company.servicehub.model.Company;

import java.util.List;

public interface CompanyDao {

//    public Company findById(Long id);

    Company addCompany(Company company);

    Company getCompany(Long id);

    List<Company> getAllCompany();

    void updateCompany(Company company);

    void deleteCompany(Long id);


}
