package com.company.servicehub.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Company {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name", unique=true, nullable = false)
    private String name;

    @Column(name = "phone", nullable = false)
    private String phone;

    protected Company() {
    }

    public Company(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Company [id=" + id + ", name=" + name + ", phone=" + phone + "]";
    }


}
