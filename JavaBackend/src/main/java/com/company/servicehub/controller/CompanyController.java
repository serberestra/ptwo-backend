package com.company.servicehub.controller;

import com.company.servicehub.model.Company;
import com.company.servicehub.repository.CompanyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("company") // http://localhost:8080/company
public class CompanyController {

    private final CompanyDao companyDao;

    @Autowired
    public CompanyController(CompanyDao companyDao){
        this.companyDao = companyDao;
    };

    @GetMapping(path = "/{id}") //http://localhost:8080/company/5001
    @ResponseStatus(value = HttpStatus.OK)
    public Company getCompanyById(@PathVariable Long id) throws Exception {
        Company company = companyDao.getCompany(id);
        if (company == null) {
            throw new Exception("Company not found.");
        }
        return company;
    }

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public List<Company> getCompanyList() {
        return companyDao.getAllCompany();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Company addCompany(@RequestBody @Valid Company company) {
        return companyDao.addCompany(company);
    }

    @PutMapping
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void updateCompany(@RequestBody @Valid Company company) {
        companyDao.updateCompany(company);

    }

    @DeleteMapping(path="/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCompany(@PathVariable Long id){
        companyDao.deleteCompany(id);
    }

    // on handling dates:
    // @RequestMapping(value="/fetch" , method=RequestMethod.GET)
    // public @ResponseBody String fetchResult(@RequestParam("from") @DateTimeFormat(pattern="yyyy-MM-dd") Date fromDate) {
    //        //Content goes here
    //    }
}
