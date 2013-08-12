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
import com.kwik.models.Product;
import com.kwik.service.ProductService;

public class ProductControllerTest extends TestHelper {

	private @Spy Result result = new MockResult();
	
	private @Spy Validator validator = new MockValidator();
	
	private @Mock ProductService service;
	
	private ProductController controller;
	
	private Product product;
	
	@Before
	public void setUp() throws Exception {
		controller = new ProductController(service, result, validator);
		product = from(Product.class).gimme(TemplateLoader.ProductTemplate.CAMISETA_BRANCA);
	}
	
	@Test
	public void shouldIncludeNewProduct() throws Exception {
		controller.add(product);
		verify(service).add(product);
	}
	
	@Test(expected = ValidationException.class)
	public void shouldValidateRequiredFields() throws Exception {
		controller.add(new Product());
	}
	
	@Test
	public void shouldExposeProductCatalog() throws Exception {
		
		List<Product> products = Fixture.from(Product.class).gimme(4, TemplateLoader.ProductTemplate.CAMISETA_PRETA_JA_ASSOCIADA);
		
		when(service.listAll()).thenReturn(products);
		
		controller.list();
		
		verify(result).use(json());
	}
	
	@Test
	public void listProductsShouldBeEmpty() throws Exception {
		
		when(service.listAll()).thenReturn(new ArrayList<Product>());
		
		controller.list();
		
		verify(result).use(Results.status());
	}
	
}
