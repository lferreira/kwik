package com.kwik.repositories.category.dao;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

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
	public Category add(Category category) {
		Category result = category;
		entityManager.merge(result);
		return result;
	}

	@Override
	public Category update(Category category) {
		return entityManager.merge(category);
	}

	@Override
	public Collection<Category> listAll() {
		Query query = entityManager.createQuery("FROM " + Category.class.getName());

		@SuppressWarnings("unchecked")
		List<Category> resultList = query.getResultList();

		return resultList;
	}

	@Override
	public Category findBy(Long id) {
		return entityManager.find(Category.class, id);
	}

	@Override
	public void destroy(Category category) {
		entityManager.remove(findBy(category.getId()));
	}
}
