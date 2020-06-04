package com.company.servicehub.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Worker {

	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "first_name", unique=true, nullable = false)
	private String firstName;

	@Column(name = "last_name", unique=true, nullable = false)
	private String lastName;

	@Column(name = "company_id", unique=true, nullable = false)
	private Long companyId;

	private String service;

	public Worker() {
	}

	public Worker(String firstName, String lastName, Long companyId, String service) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.companyId = companyId;
		this.service = service;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	@Override
	public String toString() {
		return "Worker{" +
				"id=" + id +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", companyId=" + companyId +
				", service='" + service + '\'' +
				'}';
	}
}