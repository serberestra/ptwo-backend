package com.ptwo.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ptwo.app.model.Worker;
import com.ptwo.app.service.WorkerService;

@RestController
public class WorkerController {
	
	@Autowired
	private WorkerService service;
	
	@PostMapping("/worker")
	public Worker createWorker(@RequestBody Worker worker) {
		return service.createWorker(worker);
	}

	@PutMapping("/worker")
	public Worker updateWorker(@RequestBody Worker worker) {
		return service.updateWorker(worker);
	}

	@DeleteMapping("/worker/{id}")
	public void deleteWorker(@PathVariable Long id) {
		service.deleteWorker(id);
		
	}

	@GetMapping("/worker")
	public List<Worker> getAllWorker() {
		return service.getAllWorker();
	}

	@GetMapping("/worker/{id}")
	public Worker getWorkerById(@PathVariable Long id) {
		return service.getWorkerById(id);
	}
	
	@GetMapping("/worker/company/{companyId}")
	public List<Worker> getWorkersByCompanyId(@PathVariable Long companyId){
		return service.getWorkersByCompanyId(companyId);
	}




}
