package com.kwik.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Address implements Serializable {

	private static final long serialVersionUID = 5316746667456995538L;

	@Id @GeneratedValue
	private Long id;
	
	private String district;
	
	private String location;
	
	private String street;

	private String zipCode;
	
	public String getStreet() {
		return street;
	}

	public Long getId() {
		return id;
	}

	public String getDistrict() {
		return district;
	}

	public String getLocation() {
		return location;
	}

	public String getZipCode() {
		return zipCode;
	}

	public Address district(String district) {
		this.district = district;
		return this;
	}
	
	public Address location(String location) {
		this.location = location;
		return this;
	}
	
	public Address street(String street) {
		this.street = street;
		return this;
	}

	public Address zipCode(String zipCode) {
		this.zipCode = zipCode;
		return this;
	}

	
}
