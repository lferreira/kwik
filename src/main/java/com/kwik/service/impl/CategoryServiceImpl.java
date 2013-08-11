package com.kwik.service.impl;

import static com.kwik.infra.cache.time.CacheTime.THREE_SECONDS;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import br.com.caelum.vraptor.ioc.Component;

import com.google.common.collect.Lists;
import com.kwik.infra.cache.Cache;
import com.kwik.models.Category;
import com.kwik.models.Product;
import com.kwik.repositories.category.CategoryRepository;
import com.kwik.repositories.product.ProductRepository;
import com.kwik.service.CategoryService;

@Component
public class CategoryServiceImpl implements CategoryService {

	private static final String KEY = "allCategories";

	private CategoryRepository repository;
	
	private ProductRepository productRepository;
	
	private Cache<Object> cache;
	
	public CategoryServiceImpl(CategoryRepository repository, ProductRepository productRepository, Cache<Object> cache) {
		this.productRepository = productRepository;
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
			cache.put(KEY, THREE_SECONDS.getTime(), categories);
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

	@Override
	public void associate(Category category, List<Long> ids) {
		
		category = findBy(category.getId());
		
		List<Product> products = productRepository.findBy(ids);
		category.add(products);
		repository.update(category);
	}
}
