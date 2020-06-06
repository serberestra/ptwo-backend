package com.ptwo.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ptwo.app.dao.ReservationDAO;
import com.ptwo.app.model.Reservation;
import com.ptwo.app.service.ReservationService;

@Service
public class ReservationServiceImpl implements ReservationService{
	
	@Autowired
	private ReservationDAO rdao;
	
	@Override
	public Reservation createReservation(Reservation r) {
		return rdao.save(r);
	}

	@Override
	public Reservation updateReservation(Reservation r) {
		return rdao.save(r);
	}

	@Override
	public void deleteReservation(Long id) {
		rdao.deleteById(id);
	}

	@Override
	public List<Reservation> getAllReservations() {
		return rdao.findAll();
	}

	@Override
	public Reservation getReservationById(Long id) {
		return rdao.findById(id).get();
	}

	@Override
	public List<Reservation> getReservationsByWorker(Long wID) {
		return rdao.findByWorkerId(wID);
	}

	@Override
	public List<Reservation> getReservationsByDate(String date) {
		return rdao.findByDate(date);
	}

}