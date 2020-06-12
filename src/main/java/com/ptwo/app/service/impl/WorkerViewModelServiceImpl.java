package com.ptwo.app.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ptwo.app.model.Company;
import com.ptwo.app.model.Worker;
import com.ptwo.app.service.CompanyService;
import com.ptwo.app.service.WorkerService;
import com.ptwo.app.viewModel.WorkerViewModel;

@Service
public class WorkerViewModelServiceImpl {
	
	private CompanyService companyService;
	private WorkerService workerService;
	
	@Autowired
	public WorkerViewModelServiceImpl(CompanyService companyService, WorkerService workerService) {
		this.companyService = companyService;
		this.workerService = workerService;
	}
	
	public List<WorkerViewModel> getAllWorkerViewModel(){
        List<Worker> workerList = workerService.getAllWorker();

        List<WorkerViewModel> wvmList = new ArrayList<>();

        for (Worker worker : workerList) {
            WorkerViewModel rvm = buildWorkerViewModel(worker);
            wvmList.add(rvm);
        }
        return wvmList;

	}

    private WorkerViewModel buildWorkerViewModel(Worker worker) {

        WorkerViewModel wvm = new WorkerViewModel();

        // Get worker details        
        wvm.setId(worker.getId());
        wvm.setFirstName(worker.getFirstName());
        wvm.setLastName(worker.getLastName());
        wvm.setCompanyId(worker.getCompanyId());
        wvm.setServiceName(worker.getServiceName());
       
        // Get Company details
        Company company = companyService.getCompanyById(worker.getCompanyId());
        wvm.setCompanyName(company.getName());
        wvm.setAddress(company.getAddress());
        wvm.setPhoneNumber(company.getPhoneNumber());
        
        return wvm;

    }

	
}
