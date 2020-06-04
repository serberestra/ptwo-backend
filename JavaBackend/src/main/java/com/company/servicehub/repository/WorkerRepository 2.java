package com.company.servicehub.repository;

import com.company.servicehub.model.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class WorkerRepository {
	
	@Autowired
	EntityManager em;
	
	public Worker findById(Long id){
		return em.find(Worker.class, id);
	}
	
	//public Course save(Course course) -> insert or update
	
	//public void deleteById(Long id)

}
