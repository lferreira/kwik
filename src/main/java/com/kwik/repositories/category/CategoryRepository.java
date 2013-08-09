package com.kwik.repositories.category;

import com.kwik.models.Category;

public interface CategoryRepository {

	Category add(Category category);

	Category update(Category categoryReturned);

}
