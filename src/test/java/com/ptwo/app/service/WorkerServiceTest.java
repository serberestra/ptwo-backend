package com.ptwo.app.service;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ptwo.app.model.Worker;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class WorkerServiceTest {

	@Autowired
	WorkerService workerService;
	
    @Before
    public void setUp() throws Exception {
        // Clean up the test db
        List<Worker> wList = workerService.getAllWorker();
        for (Worker w : wList) {
            workerService.deleteWorker(w.getId());
        }

    }

	@Test
	public void testCreateGetDeleteWorker() {
		Worker worker = new Worker();
		worker.setFirstName("Mark");
		worker.setLastName("Brown");
		worker.setCompanyId(5001L);
		worker.setServiceName("Appliance Installation");
		
		workerService.createWorker(worker);
		
		Worker worker1 = workerService.getWorkerById(worker.getId());
		
        assertEquals(worker1, worker);

        workerService.deleteWorker(worker.getId());
        worker1 = workerService.getWorkerById(worker.getId());
        assertNull(worker1);
	}

	@Test
	public void testUpdateWorker() {
		Worker worker = new Worker();
		worker.setFirstName("Daisy");
		worker.setLastName("Green");
		worker.setCompanyId(5001L);
		worker.setServiceName("Appliance Installation");
		
		workerService.createWorker(worker);

        worker.setLastName("Brown");
        worker.setServiceName("TV Calibration");
        workerService.updateWorker(worker);

        Worker worker1 = workerService.getWorkerById(worker.getId());

        assertEquals("Brown", worker1.getLastName());
        assertEquals("TV Calibration", worker1.getServiceName());
	}

	@Test
	public void testGetAllWorkers() {
        Worker worker = new Worker();
		worker.setFirstName("Daisy");
		worker.setLastName("Green");
		worker.setCompanyId(5001L);
		worker.setServiceName("Appliance Installation");
		
		workerService.createWorker(worker);
		
		worker = new Worker();
		worker.setFirstName("Mark");
		worker.setLastName("Brown");
		worker.setCompanyId(5001L);
		worker.setServiceName("Appliance Installation");

        workerService.createWorker(worker);

        List<Worker> cList = workerService.getAllWorker();

        assertEquals(2, cList.size());
	}

	@Test
	public void testGetWorkersByCompanyId() {
		
		
        Worker worker = new Worker();
		worker.setFirstName("Daisy");
		worker.setLastName("Green");
		worker.setCompanyId(5001L);
		worker.setServiceName("TV Calibration");
		
		workerService.createWorker(worker);
		
		worker = new Worker();
		worker.setFirstName("Mark");
		worker.setLastName("Brown");
		worker.setCompanyId(5001L);
		worker.setServiceName("Appliance Installation");

        workerService.createWorker(worker);

		worker = new Worker();
		worker.setFirstName("Richard");
		worker.setLastName("White");
		worker.setCompanyId(5002L);
		worker.setServiceName("Appliance Installation");

        workerService.createWorker(worker);

        List<Worker> cList = workerService.getWorkersByCompanyId(5001L);

        assertEquals(2, cList.size());

        cList = workerService.getWorkersByCompanyId(5002L);

        assertEquals(1, cList.size());
      
	}

}
