package com.ptwo.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ptwo.app.dao.WorkerDao;
import com.ptwo.app.model.Worker;
import com.ptwo.app.service.WorkerService;

@Service
public class WorkerServiceImp implements WorkerService {
	
	@Autowired
	WorkerDao workerDao;

	@Override
	public Worker createWorker(Worker worker) {
		// TODO Auto-generated method stub
		return workerDao.save(worker);
	}

	@Override
	public Worker updateWorker(Worker worker) {
		// TODO Auto-generated method stub
		return workerDao.save(worker);
	}

	@Override
	public void deleteWorker(Long id) {
		// TODO Auto-generated method stub
		workerDao.deleteById(id);
	}

	@Override
	public List<Worker> getAllWorker() {
		// TODO Auto-generated method stub
		return workerDao.findAll();
	}

	@Override
	public Worker getWorkerById(Long id) {
		// TODO Auto-generated method stub
		return workerDao.findById(id).get();
	}

	@Override
	public List<Worker> getWorkersByCompanyId(Long companyId){
		// TODO Auto-generated method stub
		return workerDao.findByCompanyId(companyId);
	}

}
