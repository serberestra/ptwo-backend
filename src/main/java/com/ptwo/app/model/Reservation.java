package com.ptwo.app.model;

import javax.persistence.*;

@Entity
@Table
public class Reservation {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long id;
	Long bookedBy;
	@JoinColumn
	Long workerId;
	String date;
	@Column(name="AVAILABLE")
	Boolean status;
	
	
	public Reservation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Reservation(Long id, Long bookedBy, Long workerId, String date, Boolean status) {
		super();
		this.id = id;
		this.bookedBy = bookedBy;
		this.workerId = workerId;
		date = date;
		this.status = status;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getBookedBy() {
		return bookedBy;
	}
	public void setBookedBy(Long bookedBy) {
		this.bookedBy = bookedBy;
	}
	public Long getWorkerId() {
		return workerId;
	}
	public void setWorkerId(Long workerId) {
		this.workerId = workerId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String Date) {
		date = Date;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "Reservation [id=" + id + ", bookedBy=" + bookedBy + ", workerId=" + workerId + ", Date=" + date
				+ ", status=" + status + "]";
	}
	
}
