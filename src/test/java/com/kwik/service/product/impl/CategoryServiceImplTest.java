package com.kwik.service.product.impl;

import static br.com.six2six.fixturefactory.Fixture.from;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import com.kwik.fixture.load.TemplateLoader;
import com.kwik.helper.TestHelper;
import com.kwik.infra.cache.Cache;
import com.kwik.models.Category;
import com.kwik.models.Product;
import com.kwik.repositories.category.CategoryRepository;
import com.kwik.repositories.product.ProductRepository;
import com.kwik.service.category.CategoryService;
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
	
	@Test
	public void shouldIncludeNewCategory() throws Exception {
		
		Category category = from(Category.class).gimme(TemplateLoader.CategoryTemplate.CATEGORIA_ROUPAS);
		
		service.add(category);
		
		verify(repository).add(category);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void shouldAddCategoryInCache() throws Exception {
		
		when(cache.get(anyString())).thenReturn(null);
		
		service.listAll();
		
		verify(cache).put(anyString(), anyInt(), (ArrayList<Category>) anyObject());
	}
	
	@Test
	public void shouldGetCategoriesFromCache() throws Exception {
		
		List<Category> categories = from(Category.class).gimme(10, TemplateLoader.CategoryTemplate.CATEGORIA_ROUPAS);
		
		when(cache.getList(anyString())).thenReturn(new ArrayList<Object>(categories));
		
		verify(cache, never()).put(anyString(), anyInt(), (Product) anyObject());;
	}
	
	@Test
	public void shouldDestroyCategory() throws Exception {
		
		Category category = from(Category.class).gimme(TemplateLoader.CategoryTemplate.CATEGORIA_ROUPAS);
		
		service.destroy(category);
		
		verify(repository).destroy(category);
	}
}
