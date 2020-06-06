package com.ptwo.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ptwo.app.model.Worker;

public interface WorkerDao extends JpaRepository<Worker, Long>{
	
	public List<Worker> findByCompanyId(Long id);

}
