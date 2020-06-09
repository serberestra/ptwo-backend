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
import com.ptwo.app.service.impl.ReservationViewModelServiceImpl;
import com.ptwo.app.viewModel.ReservationViewModel;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class ReservationViewModelController {
	
    private final ReservationViewModelServiceImpl vmService;

	@Autowired
	public ReservationViewModelController(ReservationViewModelServiceImpl vmService) {
		this.vmService = vmService;
	}

	@PostMapping("/reservation-view")
	public ReservationViewModel createReservationViewModel(@RequestBody ReservationViewModel viewModel) throws Exception{
		return vmService.saveReservationViewModel(viewModel);
	}

	@PutMapping("/reservation-view")
	public ReservationViewModel updateReservationViewModel(@RequestBody ReservationViewModel viewModel) throws Exception {
		return vmService.updateReservationViewModel(viewModel);
	}

//	@DeleteMapping("/reservation-view/{id}")
//	public void deleteReservation(@PathVariable("id") Long id) {
//		service.deleteReservation(id);
//	}

	@GetMapping("/reservation-views")
	public List<ReservationViewModel> getAllReservationsViewModels() {
		return vmService.getAllReservationViewModel();
	}

	@GetMapping("/reservation-view/{id}")
	public ReservationViewModel getReservationById(@PathVariable("id") Long reservationId) {
		return vmService.getReservationViewModel(reservationId);
	}

//	@GetMapping("/reservations-view/worker/{id}")
//	public List<Reservation> getReservationsByWorker(@PathVariable("id") Long wID) {
//		return service.getReservationsByWorker(wID);
//	}
	
//	@GetMapping("/reservations-view/date/{date}")
//	public List<Reservation> getReservationsByDate(@PathVariable("date") Date date) {
//		return service.getReservationsByDate(date);
//	}

//	@GetMapping("/reservations-view/worker/{id}")
//	public List<Reservation> getReservationsByCompany(@PathVariable("id") Long wID) {
//		return service.getReservationsByWorker(wID);
	
	

}
