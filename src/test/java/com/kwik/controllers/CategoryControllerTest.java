package com.kwik.controllers;

import static br.com.caelum.vraptor.view.Results.json;
import static br.com.six2six.fixturefactory.Fixture.from;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Spy;

import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.util.test.MockResult;
import br.com.caelum.vraptor.util.test.MockValidator;
import br.com.caelum.vraptor.validator.ValidationException;
import br.com.caelum.vraptor.view.Results;
import br.com.six2six.fixturefactory.Fixture;

import com.kwik.fixture.load.TemplateLoader;
import com.kwik.helper.TestHelper;
import com.kwik.models.Category;
import com.kwik.service.category.CategoryService;

public class CategoryControllerTest extends TestHelper {
	
	private @Spy Result result = new MockResult();
	
	private @Spy Validator validator = new MockValidator();
	
	private @Mock CategoryService service;
	
	private CategoryController controller;
	
	private Category category;
	
	@Before
	public void setUp() {
		controller = new CategoryController(service, result, validator);
		category = from(Category.class).gimme(TemplateLoader.CategoryTemplate.CATEGORIA_ROUPAS);
	}
	
	@Test
	public void shouldListCategoriesWithProducts() throws Exception {
		
		List<Category> categories = Fixture.from(Category.class).gimme(4, TemplateLoader.CategoryTemplate.CATEGORIA_ROUPAS);
		
		when(service.listAll()).thenReturn(categories);
		
		controller.list();
		verify(result).use(json());
	}
	
	@Test
	public void listCategoriesWithProductsShouldBeEmpty() throws Exception {
		
		when(service.listAll()).thenReturn(new ArrayList<Category>());
		
		controller.list();
		verify(result).use(Results.status());
	}
	
	@Test
	public void shouldIncludeCategory() throws Exception {
		controller.add(category);
		verify(service).add(category);
	}
	
	@Test(expected = ValidationException.class)
	public void shouldValidateRequiredFields() throws Exception {
		controller.add(new Category());
	}
	
	@Test
	public void shoulFindCategoryById() throws Exception {
		
		Long id = 1l;
		
		when(service.findBy(id)).thenReturn(category);
		
		controller.edit(id);
		verify(result).include("category", category);
	}
	
	@Test
	public void shouldAssociateProductsToCategory() throws Exception {
		
		List<Long> ids = new ArrayList<Long>();
		
		controller.associate(category, ids);
		
		verify(service).associate(category, ids);
		
		verify(result).use(Results.status());
	}
	
}
