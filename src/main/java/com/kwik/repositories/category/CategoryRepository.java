package com.kwik.repositories.category;

import java.util.Collection;

import com.kwik.models.Category;

public interface CategoryRepository {

	Category add(Category category);

	Category update(Category categoryReturned);

	Collection<Category> listAll();

	Category findBy(Long id);

}
