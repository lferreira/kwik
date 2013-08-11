package com.kwik.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import br.com.caelum.vraptor.ioc.Component;

import com.google.common.collect.Lists;
import com.kwik.infra.cache.Cache;
import com.kwik.models.Category;
import com.kwik.repositories.category.CategoryRepository;
import com.kwik.service.CategoryService;

@Component
public class CategoryServiceImpl implements CategoryService {

	private static final String KEY = "allCategories";

	private static final int ONE_HOUR = 3600;
	
	private CategoryRepository repository;
	
	private Cache<Category> cache;
	
	public CategoryServiceImpl(CategoryRepository repository, Cache<Category> cache) {
		this.repository = repository;
		this.cache = cache;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Category> listAll() {

		List<Category> categories = Lists.newArrayList();
		
		Object cached = cache.get(KEY);
		
		if (cached != null) {
			
			categories  = (ArrayList<Category>) cached;
			
		} else {
			
			categories = (List<Category>) repository.listAll();
			cache.put(KEY, ONE_HOUR, categories);
		}
		
		return categories;
	}

	@Override
	public void add(Category category) {
		repository.add(category);
	}

	@Override
	public Category findBy(Long id) {
		return repository.findBy(id);
	}
}
