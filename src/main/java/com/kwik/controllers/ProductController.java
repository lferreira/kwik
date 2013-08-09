package com.kwik.controllers;

import static org.apache.commons.lang.StringUtils.isNotEmpty;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.Validations;

import com.kwik.models.Product;
import com.kwik.service.ProductsService;

public class ProductController {
	
	private Result result;

	private Validator validator;
	
	private ProductsService service;
	
	public ProductController(final ProductsService service, final Result result, final Validator validator) {
		this.service = service;
		this.result = result;
		this.validator = validator;
	}
	
	public void save(final Product product) {
		
		validator.checking(new Validations() { {
			that(isNotEmpty(product.getDescription()), "erro", "description.is.required");
			that(product.getValue() != null && product.getValue() > 0, "erro", "description.is.required");
		} });
		
		validator.onErrorRedirectTo(this);
		
		service.save(product);
	}
}
