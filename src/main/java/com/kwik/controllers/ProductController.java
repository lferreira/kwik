package com.kwik.controllers;

import static br.com.caelum.vraptor.view.Results.json;
import static org.apache.commons.lang.StringUtils.isNotEmpty;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.Validations;

import com.kwik.models.Product;
import com.kwik.service.ProductService;

@Resource
public class ProductController {
	
	private Result result;

	private Validator validator;
	
	private ProductService service;
	
	public ProductController(final ProductService service, final Result result, final Validator validator) {
		this.service = service;
		this.result = result;
		this.validator = validator;
	}
	
	@Post
	public void save(final Product product) {
		
		validator.checking(new Validations() { {
			that(isNotEmpty(product.getDescription()), "erro", "description.is.required");
			that(product.getValue() != null && product.getValue() > 0, "erro", "value.is.required");
		} });
		
		validator.onErrorRedirectTo(this);
		
		service.save(product);
	}

	@Get
	public void list() {
		result.use(json()).from(service.listProducts()).include("products").serialize();
	}
}
