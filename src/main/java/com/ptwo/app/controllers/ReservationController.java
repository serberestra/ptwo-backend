package com.ptwo.app.controllers;

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
@RequestMapping("/api/reservation")
public class ReservationController {

	@Autowired
	private ReservationService service;
	
	@PostMapping("/create")
	public Reservation createReservation(@RequestBody Reservation r) {
		return service.createReservation(r);
	}

	@PutMapping("/update")
	public Reservation updateReservation(Reservation r) {
		return service.updateReservation(r);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteReservation(@PathVariable("id") Long id) {
		service.deleteReservation(id);
	}

	@GetMapping("/list")
	public List<Reservation> getAllReservations() {
		return service.getAllReservations();
	}

	@GetMapping("/list/{id}")
	public Reservation getReservationById(@PathVariable("id") Long id) {
		return service.getReservationById(id);
	}

	@GetMapping("/list/filterByWorker/{id}")
	public List<Reservation> getReservationsByWorker(@PathVariable("id") Long wID) {
		return service.getReservationsByWorker(wID);
	}
	
	@GetMapping("/list/filterByDate/{date}")
	public List<Reservation> getReservationsByDate(@PathVariable("date") String date) {
		return service.getReservationsByDate(date);
	}

}
