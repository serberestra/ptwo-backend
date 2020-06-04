package com.company.servicehub;

import com.company.servicehub.model.Company;
import com.company.servicehub.model.Worker;
import com.company.servicehub.repository.CompanyRepository;
import com.company.servicehub.repository.WorkerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ServiceHubApplication implements CommandLineRunner{
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private WorkerRepository repository;

	@Autowired
	private CompanyRepository companyRepository;

	public static void main(String[] args) {
		SpringApplication.run(ServiceHubApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		Worker worker = repository.findById(1001L);
		Company company = companyRepository.findById(5001L);

		logger.info("Worker 1001 -> {}", worker);
		logger.info("Company 5001 -> {}",  company);

	}
}
