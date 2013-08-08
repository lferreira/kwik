package com.kwik.repositories;

import javax.persistence.EntityManager;

import com.kwik.models.Product;
import com.kwik.repositories.produto.ProductRepository;


public class ProductDAO implements ProductRepository {

	private EntityManager entityManager;
	
	public ProductDAO(EntityManager entityManager) {
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
}
