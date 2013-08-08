package com.kwik.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.google.common.collect.Lists;

@Entity
public class Category {

	@Id @GeneratedValue
	private Long id;
	
	@Column(nullable = false)
	private String description;

	@OneToMany
	private List<Product> products = Lists.newArrayList();
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Product> getProducts() {
		return products;
	}
	
	public void add(Product product) {
		products.add(product);
	}
	
	public void add(List<Product> product) {
		products.addAll(product);
	}
}
