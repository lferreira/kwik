package com.kwik.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Type;
import org.joda.time.LocalDateTime;

@Entity
public class Product {

	@Id @GeneratedValue
	private Long id;
	
	@Column(nullable = false)
	private String description;
	
	private Double value;
	
	@Column(name="created", nullable = false)
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
    private LocalDateTime created = LocalDateTime.now();
	
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

	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}
}
