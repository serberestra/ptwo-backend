package com.ptwo.app.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.stereotype.Service;

import com.ptwo.app.dao.ReservationDAO;
import com.ptwo.app.dao.WorkerDao;
import com.ptwo.app.model.Reservation;
import com.ptwo.app.model.Worker;
import com.ptwo.app.service.WorkerService;

@Service
public class WorkerServiceImp implements WorkerService {
	
	@Autowired
	private WorkerDao workerDao;
	
	@Autowired
	private ReservationDAO rdao;


	@Override
	public Worker createWorker(Worker worker) {
		try {
			return workerDao.save(worker);
		} catch (DataIntegrityViolationException e) {
			return null;
		}

	}

	@Override
	public Worker updateWorker(Worker worker) {
		try {
			return workerDao.save(worker);
		} catch (DataIntegrityViolationException e) {
			return null;
		}
	}

	@Override
	public void deleteWorker(Long id) {
				
		List<Reservation> rList = new ArrayList<>();
		rList = rdao.findByWorkerId(id);
		for (Reservation reservation: rList) {
			rdao.deleteById(reservation.getId());
		}		
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
		try {
			return workerDao.findById(id).get();
        } catch (NoSuchElementException e) {
            // if there is no Company with this id, just return null
            return null;
        }
		
	}

	@Override
	public List<Worker> getWorkersByCompanyId(Long companyId){
		// TODO Auto-generated method stub
		return workerDao.findByCompanyId(companyId);
	}

}
