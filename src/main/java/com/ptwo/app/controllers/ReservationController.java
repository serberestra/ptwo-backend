package com.ptwo.app.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ptwo.app.model.Reservation;
import com.ptwo.app.service.ReservationService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class ReservationController {

	@Autowired
	private ReservationService service;
	
	@PostMapping("/reservation")
	public Reservation createReservation(@RequestBody Reservation r) {
		return service.createReservation(r);
	}

	@PutMapping("/reservation")
	public Reservation updateReservation(Reservation r) {
		return service.updateReservation(r);
	}

	@DeleteMapping("/reservation/{id}")
	public void deleteReservation(@PathVariable("id") Long id) {
		service.deleteReservation(id);
	}

	@GetMapping("/reservations")
	public List<Reservation> getAllReservations() {
		return service.getAllReservations();
	}

	@GetMapping("/reservation/{id}")
	public Reservation getReservationById(@PathVariable("id") Long id) {
		return service.getReservationById(id);
	}

	@GetMapping("/reservations/worker/{id}")
	public List<Reservation> getReservationsByWorker(@PathVariable("id") Long wID) {
		return service.getReservationsByWorker(wID);
	}
	
	@GetMapping("/reservations/date/{date}")
	public List<Reservation> getReservationsByDate(@PathVariable("date") Date date) {
		return service.getReservationsByDate(date);
	}

}
