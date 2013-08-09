package com.kwik.controllers;

import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;

import com.kwik.models.Product;
import com.kwik.service.ProductsService;

public class ProductController {
	
	private Result result;

	private ProductsService service;
	
	public ProductController(final ProductsService service, final Result result) {
		this.service = service;
		this.result = result;
	}
	
	@Post
	public void save(Product product) {
		service.save(product);
	}
}
