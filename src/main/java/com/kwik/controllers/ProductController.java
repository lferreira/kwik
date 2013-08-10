package com.kwik.controllers;

import static br.com.caelum.vraptor.view.Results.json;
import static com.google.common.base.Strings.isNullOrEmpty;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.ValidationMessage;

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
	
	@Get
	public void add() {}
	
	@Post
	public void add(final Product product) {
		valid(product);
		service.add(product);
		result.redirectTo(this).list();
	}
	
	@Get
	public void list() {
		result.use(json()).from(service.listProducts()).serialize();
	}
	
	private void valid(final Product product) {
		if (isNullOrEmpty(product.getName())) {
			validator.add(new ValidationMessage("erro", "name.is.required"));
		} else if (isNullOrEmpty(product.getDescription())) {
			validator.add(new ValidationMessage("erro", "description.is.required"));
		} else if (product.getValue() == null || product.getValue() < 0) {
			validator.add(new ValidationMessage("erro", "value.is.required"));
		}
		validator.onErrorRedirectTo(this);
	}
}
