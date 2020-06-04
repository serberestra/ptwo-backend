package com.company.servicehub.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
//@NamedQuery(name = "Company.getAllCompany", query="SELECT c from COMPANY c");
public class Company {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name", unique=true)
    @NotNull(message = "Company name is required.")
    private String name;

    @Column(name = "phone_number", nullable = false)
    @NotNull(message = "Company phone is required.")
    @Size(min=5, max=10, message="Number of digits should be between 5 to 10")
    private String phoneNumber;

    @Column(name = "address", nullable = false)
    private String address;

    protected Company() {
    }

    public Company(String name, String phone) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return Objects.equals(getId(), company.getId()) &&
                Objects.equals(getName(), company.getName()) &&
                Objects.equals(getPhoneNumber(), company.getPhoneNumber()) &&
                Objects.equals(getAddress(), company.getAddress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getPhoneNumber(), getAddress());
    }
}
