package com.ptwo.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ptwo.app.service.impl.ReservationViewModelServiceImpl;
import com.ptwo.app.service.impl.WorkerViewModelServiceImpl;
import com.ptwo.app.viewModel.ReservationViewModel;
import com.ptwo.app.viewModel.WorkerViewModel;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class WorkerViewModelController {
	
    private final WorkerViewModelServiceImpl vmService;
	
	@Autowired
	public WorkerViewModelController(WorkerViewModelServiceImpl vmService) {
		this.vmService = vmService;
	}

	@GetMapping("/workers-view")
	public List<WorkerViewModel> getAllReservationsViewModels() {
		return vmService.getAllWorkerViewModel();
	}


}
