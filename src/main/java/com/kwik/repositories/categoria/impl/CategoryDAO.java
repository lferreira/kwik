package com.kwik.repositories.categoria.impl;

import javax.persistence.EntityManager;

import com.kwik.models.Category;
import com.kwik.repositories.CategoryRepository;

public class CategoryDAO implements CategoryRepository {

	private EntityManager entityManager;

	public CategoryDAO(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	@Override
	public Category save(Category category) {
		Category result = category;
		entityManager.merge(result);
		return result;
	}
}
