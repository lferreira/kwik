package com.kwik.repositories.product;

import java.util.List;

import com.kwik.models.Product;

public interface ProductRepository {
	
	Product add(Product product);

	Product update(Product product);

	List<Product> listAll();

	List<Product> findBy(List<Long> ids);

	Product findBy(Long id);

	void destroy(Product product);

}
