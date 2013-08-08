package com.kwik.repositories.product.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.kwik.models.Product;
import com.kwik.repositories.product.ProductRepository;


public class ProductDao implements ProductRepository {

	private EntityManager entityManager;
	
	public ProductDao(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public Product save(Product product) {
		Product result = product;
		entityManager.persist(result);
		return result;
	}

	@Override
	public Product update(Product product) {
		return entityManager.merge(product);
	}

	@Override
	public List<Product> listAll() {
		Query query = entityManager.createQuery("FROM " + Product.class.getName());

		@SuppressWarnings("unchecked")
		List<Product> resultList = query.getResultList();

		return resultList;
	}
}
