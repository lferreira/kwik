package com.kwik.controllers;

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
import com.kwik.helper.DatabaseTestHelper;
import com.kwik.models.Product;
import com.kwik.service.ProductsService;

public class ProductControllerTest extends DatabaseTestHelper {

	private @Spy Result result = new MockResult();
	
	private @Spy Validator validator = new MockValidator();
	
	private @Mock ProductsService service;
	
	private ProductController controller;
	
	private Product product;
	
	@Before
	public void setUp() throws Exception {
		controller = new ProductController(service, result, validator);
		product = from(Product.class).gimme(TemplateLoader.ProductTemplate.CAMISETA_BRANCA);
	}
	
	@Test
	public void shouldIncludeNewProduct() throws Exception {
		controller.save(product);
		verify(service).save(product);
	}
	
	@Test(expected = ValidationException.class)
	public void shouldValidateRequiredFields() throws Exception {
		controller.save(new Product());
	}
}
