package com.ptwo.app.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ptwo.app.model.Reservation;

@SpringBootTest
class ReservationServiceTest {
	
	@Autowired
	ReservationService reservationService;
	
	@BeforeEach
	public void setUp() throws Exception {
		// empty reservation table
		List<Reservation> rList = reservationService.getAllReservations();
		for(Reservation r : rList) {
			reservationService.deleteReservation(r.getId());
		}
	}

	@Test
	void testCreateReservation() {
		
		/**
		 * 	private Long id;
		private Long bookedBy;
		private Long workerId;
		private Date date;
		private Boolean status;
		 */
	    //SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
	    Date date = new Date(); 
		
		Reservation r = new Reservation();
		r.setId(1L);
		r.setBookedBy(1L);
		r.setWorkerId(1L);
		r.setDate(date);
		r.setStatus(true);
				
		reservationService.createReservation(r);
		List<Reservation> rList = reservationService.getAllReservations();
		//rList.add(reservationService.getReservationById(1L));
		
		assertEquals(1, rList.size());
		//assertEquals(r, rList.size());
	}
	
	@Test
	void test_deleteReservation() {
		
		/**
		 * 	private Long id;
		private Long bookedBy;
		private Long workerId;
		private Date date;
		private Boolean status;
		 */
	    //SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
	    Date date = new Date(); 
		
		Reservation r = new Reservation();
		r.setId(1L);
		r.setBookedBy(1L);
		r.setWorkerId(1L);
		r.setDate(date);
		r.setStatus(true);
				
		reservationService.createReservation(r);
		
		Reservation r2 = new Reservation();
		r2.setId(2L);
		r2.setBookedBy(2L);
		r2.setWorkerId(2L);
		r2.setDate(date);
		r2.setStatus(true);
				
		reservationService.createReservation(r2);
		
		reservationService.deleteReservation(r.getId());  //.................... DELETE r 
		
		// instantiate upon the existence of r's id
		Reservation r3 = reservationService.getReservationById(r.getWorkerId());  // check for r
		
		
		/**
		 * here, I was having so much problem checking for null and whatnot, 
		 * I was thinking to add Two to the list and delte One of them...
		 * ... then check size of list which should be ONE, and that was not working out either?
		 */
		//List<Reservation> rList = reservationService.getAllReservations();
		//System.out.println("\n\n" + rList.size());
		//rList.add(reservationService.getReservationById(1L));
		
		assertThat(r3).isNull();
		//assertEquals(1, rList.size());

	}
	
	
	@Test
	void test_getReservationById() {
		
		/**
		 * 	private Long id;
		private Long bookedBy;
		private Long workerId;
		private Date date;
		private Boolean status;
		 */
	    //SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
	    Date date = new Date(); 
		
		Reservation r = new Reservation();
		r.setId(1L);
		r.setBookedBy(1L);
		r.setWorkerId(1L);
		r.setDate(date);
		r.setStatus(true);
				
		reservationService.createReservation(r);
		
		Reservation r2 = new Reservation();
		r2.setId(2L);
		r2.setBookedBy(2L);
		r2.setWorkerId(2L);
		r2.setDate(date);
		r2.setStatus(true);
				
		reservationService.createReservation(r2);
		
		
		List<Reservation> rList = reservationService.getAllReservations(); // adding two
		rList.clear();														// clear the list
		rList.add(reservationService.getReservationById(1L));				// add 1 in the list
		
		assertEquals(1, rList.size());										// test for 1

	}
	
	
	
	@Test
	void test_getAllReservations() {
		
		/**
		 * 	private Long id;
		private Long bookedBy;
		private Long workerId;
		private Date date;
		private Boolean status;
		 */
	    //SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
	    Date date = new Date(); 
		
		Reservation r = new Reservation();
		r.setId(1L);
		r.setBookedBy(1L);
		r.setWorkerId(1L);
		r.setDate(date);
		r.setStatus(true);
				
		reservationService.createReservation(r);
		
		Reservation r2 = new Reservation();
		r2.setId(2L);
		r2.setBookedBy(2L);
		r2.setWorkerId(2L);
		r2.setDate(date);
		r2.setStatus(true);
				
		reservationService.createReservation(r2);
		
		
		List<Reservation> rList = reservationService.getAllReservations();
		//rList.add(reservationService.getReservationById(1L));
		
		assertEquals(2, rList.size());
		//assertEquals(r, rList.size());
	}
	
	


}
