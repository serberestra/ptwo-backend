package com.ptwo.app.service;

import java.util.List;

import com.ptwo.app.model.Worker;

public interface WorkerService {

	public Worker createWorker(Worker worker);
	public Worker updateWorker(Worker worker);
	public void deleteWorker(Long id);
	public List<Worker> getAllWorker();
	public Worker getWorkerById(Long id);
	
	public List<Worker> getWorkersByCompanyId(Long companyId);

}
