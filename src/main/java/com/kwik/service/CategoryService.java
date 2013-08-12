package com.kwik.service;

import java.util.Collection;
import java.util.List;

import com.kwik.models.Category;

public interface CategoryService {

	Collection<Category> listAll();

	void add(Category category);

	Category findBy(Long id);

	void associate(Category category, List<Long> ids);

	void destroy(Category category);

}
