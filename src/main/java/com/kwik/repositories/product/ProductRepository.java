package com.kwik.repositories.product;

import java.util.List;

import com.kwik.models.Product;

public interface ProductRepository {
	
	public Product save(Product product);

	public Product update(Product product);

	public List<Product> listAll();

}
