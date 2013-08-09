package com.kwik.controllers;

import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Spy;

import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.util.test.MockResult;

import com.kwik.helper.DatabaseTestHelper;
import com.kwik.models.Product;
import com.kwik.service.ProductsService;

public class ProductControllerTest extends DatabaseTestHelper {

	private @Spy Result result = new MockResult();
	
	private @Mock ProductsService service;
	
	private ProductController controller;
	
	private Product product;
	
	@Before
	public void setUp() throws Exception {
		controller = new ProductController(service, result);
		product = new Product();
	}
	
	@Test
	public void shouldIncludeNewProduct() throws Exception {
		controller.save(product);
		verify(service).save(product);
	}
}
