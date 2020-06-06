package com.ptwo.app.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ptwo.app.model.Reservation;

@Repository
public interface ReservationDAO extends JpaRepository<Reservation, Long> {
	public List<Reservation> findByWorkerId(Long id);
	public List<Reservation> findByDate(String date);
}
