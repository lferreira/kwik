package com.kwik.controllers;

import static br.com.caelum.vraptor.view.Results.json;

import java.util.List;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

import com.kwik.models.Product;
import com.kwik.service.ProductService;

@Resource
public class IndexController {

	private ProductService service;
	
	private Result result;
	
	public IndexController(final ProductService service, final Result result) {
		this.service = service;
		this.result = result;
	}

	@Path("/")
	public void index() {
		latestIncludedProducts();
	}

	@Get
	private void latestIncludedProducts() {
		List<Product> products = service.listProducts();
		result.use(json()).from(products).include("products").serialize();
	}

}
