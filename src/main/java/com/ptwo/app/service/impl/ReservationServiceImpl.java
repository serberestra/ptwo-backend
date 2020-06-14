package com.ptwo.app.service.impl;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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
		try {
			return rdao.save(r);
		} catch (DataIntegrityViolationException e) {
			return null;
		}
	}

	@Override
	public Reservation updateReservation(Reservation r) {
		try {
			return rdao.save(r);
		} catch (DataIntegrityViolationException e) {
			return null;
		}
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
		try {
			return rdao.findById(id).get();
        } catch (NoSuchElementException e) {
            return null;
        }
	}

	@Override
	public List<Reservation> getReservationsByWorker(Long wID) {
		return rdao.findByWorkerId(wID);
	}

	@Override
	public List<Reservation> getReservationsByDate(Date date) {
		return rdao.findByDate(date);
	}

}
