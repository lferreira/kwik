package com.kwik.controllers;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Spy;

import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.util.test.MockResult;

import com.kwik.helper.DatabaseTestHelper;
import com.kwik.models.Product;
import com.kwik.service.ProductService;

public class IndexControllerTest extends DatabaseTestHelper {

	private @Spy Result result = new MockResult();
	
	private @Mock ProductService service;
	
	private IndexController controller;
	
	@Before
	public void setUp() throws Exception {
		controller = new IndexController(service, result);
	}
	
	@Test
	public void shouldListIncludedProducts() throws Exception {
		
		ArrayList<Product> products = new ArrayList<Product>();
		when(service.listProducts()).thenReturn(products);
		
		controller.index();
		
		verify(result).include("products", products);
	}
	
}
