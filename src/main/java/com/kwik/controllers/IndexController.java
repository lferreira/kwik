package com.kwik.controllers;

import java.util.List;

import com.kwik.models.Product;
import com.kwik.service.ProductsService;

import br.com.caelum.vraptor.Result;

import static br.com.caelum.vraptor.view.Results.*;

public class IndexController {

	private ProductsService service;
	
	private Result result;
	
	public IndexController(final ProductsService service, final Result result) {
		this.service = service;
		this.result = result;
	}

	public void index() {
		List<Product> products = service.listProducts();
		result.use(json()).from(products).include("products").serialize();
	}

}
