package com.kwik.repositories.produto;

import java.util.List;

import com.kwik.models.Product;

public interface ProductRepository {
	
	public Product save(Product produto);

	public Product update(Product returned);

	public List<Product> listAll();

}
