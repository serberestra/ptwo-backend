package com.ptwo.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ptwo.app.model.Company;
import com.ptwo.app.model.Worker;
import com.ptwo.app.service.CompanyService;
import com.ptwo.app.service.WorkerService;

@SpringBootApplication
public class PtwoBackendApplication implements CommandLineRunner {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CompanyService companyService;
	
	@Autowired
	private WorkerService workerService;


	public static void main(String[] args) {
		SpringApplication.run(PtwoBackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Company company = companyService.getCompanyById(5001L);
		Worker worker = workerService.getWorkerById(1001L);

		
		logger.info("Company 5001 -> {}",  company);
		logger.info("Worker 1001 -> {}",  worker);

		
	}

}
