package com.kwik.service.product.impl;

import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import com.kwik.helper.TestHelper;
import com.kwik.infra.cache.Cache;
import com.kwik.repositories.category.CategoryRepository;
import com.kwik.repositories.product.ProductRepository;
import com.kwik.service.CategoryService;
import com.kwik.service.impl.CategoryServiceImpl;

public class CategoryServiceImplTest extends TestHelper {

	private @Mock Cache<Object> cache;

	private @Mock CategoryRepository repository;
	
	private @Mock ProductRepository productRepository;
	
	private CategoryService service;
	
	@Before
	public void setUp() {
		service = new CategoryServiceImpl(repository, productRepository, cache);
	}
	
	@Test
	public void shouldListCategories() throws Exception {
		service.listAll();
		verify(repository).listAll();
	}
}
