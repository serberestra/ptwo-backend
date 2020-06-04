package com.company.servicehub.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

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

	private String serviceName;

	public Worker() {
	}

	public Worker(String firstName, String lastName, Long companyId, String service_name) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.companyId = companyId;
		this.serviceName = serviceName;
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

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	@Override
	public String toString() {
		return "Worker{" +
				"id=" + id +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", companyId=" + companyId +
				", serviceName='" + serviceName + '\'' +
				'}';
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Worker worker = (Worker) o;
		return getId().equals(worker.getId()) &&
				getFirstName().equals(worker.getFirstName()) &&
				getLastName().equals(worker.getLastName()) &&
				getCompanyId().equals(worker.getCompanyId()) &&
				getServiceName().equals(worker.getServiceName());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId(), getFirstName(), getLastName(), getCompanyId(), getServiceName());
	}
}