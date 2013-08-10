package com.kwik.controllers;

import static br.com.caelum.vraptor.view.Results.json;
import static br.com.six2six.fixturefactory.Fixture.from;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Spy;

import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.util.test.MockResult;
import br.com.caelum.vraptor.util.test.MockValidator;
import br.com.caelum.vraptor.validator.ValidationException;

import com.kwik.fixture.load.TemplateLoader;
import com.kwik.helper.TestHelper;
import com.kwik.models.Category;
import com.kwik.service.CategoryService;

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
		controller.list();
		verify(result).use(json());
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
}
