package com.kwik.repositories.category.impl;

import javax.persistence.EntityManager;

import br.com.caelum.vraptor.ioc.Component;

import com.kwik.models.Category;
import com.kwik.repositories.category.CategoryRepository;

@Component
public class CategoryDao implements CategoryRepository {

	private EntityManager entityManager;

	public CategoryDao(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	@Override
	public Category save(Category category) {
		Category result = category;
		entityManager.merge(result);
		return result;
	}

	@Override
	public Category update(Category category) {
		return entityManager.merge(category);
	}
}
