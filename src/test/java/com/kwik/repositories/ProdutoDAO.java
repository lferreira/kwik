package com.kwik.repositories;

import javax.persistence.EntityManager;

public class ProdutoDAO extends ProdutoRepository {

	private EntityManager entityManager;
	
	public ProdutoDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}
