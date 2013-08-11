package com.kwik.service;

import java.util.Collection;

import com.kwik.models.Category;

public interface CategoryService {

	Collection<Category> listAll();

	void add(Category category);

	Category findBy(Long id);

}
