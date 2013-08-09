package com.kwik.repositories.category;

import com.kwik.models.Category;

public interface CategoryRepository {

	Category save(Category category);

	Category update(Category categoryReturned);

}
