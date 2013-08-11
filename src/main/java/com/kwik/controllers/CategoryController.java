package com.kwik.controllers;

import static br.com.caelum.vraptor.view.Results.json;
import static com.google.common.base.Strings.isNullOrEmpty;

import java.util.List;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.ValidationMessage;
import br.com.caelum.vraptor.view.Results;

import com.kwik.models.Category;
import com.kwik.service.CategoryService;

@Resource
public class CategoryController {

	private CategoryService service;
	
	private Result result;
	
	private Validator validator;
	
	public CategoryController(final CategoryService service, final Result result, final Validator validator) {
		this.service = service;
		this.result = result;
		this.validator = validator;
	}

	@Get
	public void add() {}
	
	@Post
	public void add(Category category) {
		valid(category);
		service.add(category);
		result.use(Results.status()).ok();
	}

	@Get
	public void list() {
		
		List<Category> list = (List<Category>) service.listAll();
		
		if (list.isEmpty()) {
			result.use(Results.status()).noContent();
		} else {
			result.use(json()).from(list).serialize();
		}
	}
	
	@Get("category/edit/{id}")
	public void edit(Long id) {
		result.include("category", service.findBy(id));
	}
	
	@Post
	public void associate(Category category, List<Long> ids) {
		service.associate(category, ids);
		result.use(Results.status()).ok();
	}
	
	private void valid(final Category category) {
		if (isNullOrEmpty(category.getDescription())) {
			validator.add(new ValidationMessage("erro", "description.is.required"));
		} 
		validator.onErrorRedirectTo(this);
	}


}
