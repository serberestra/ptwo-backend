package com.ptwo.app.service;

import java.util.Date;
import java.util.List;

import com.ptwo.app.model.Reservation;

public interface ReservationService {
	public Reservation createReservation(Reservation r);
	public Reservation updateReservation(Reservation r);
	public void deleteReservation(Long id);
	public List<Reservation> getAllReservations();
	public Reservation getReservationById(Long id);
	public List<Reservation> getReservationsByWorker(Long wID);
	public List<Reservation> getReservationsByDate(Date date);
	
}
