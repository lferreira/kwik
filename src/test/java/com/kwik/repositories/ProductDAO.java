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
	public Product save(Product produto) {
		Product resultado = produto;
		entityManager.persist(resultado);
		return resultado;
	}
}
