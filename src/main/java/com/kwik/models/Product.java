package com.kwik.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Product {

	@Id @GeneratedValue
	private Long id;
	
	@Column(nullable = false)
	private String description;
	
	private Double value;
	
	@OneToOne
	private Specifics specifics;
	
	public Long getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public Specifics getSpecifics() {
		return specifics;
	}

	public void setSpecifics(Specifics specifics) {
		this.specifics = specifics;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
