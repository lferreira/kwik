package com.kwik.service;

import java.util.List;

import com.kwik.models.Product;

public interface ProductsService {

	List<Product> listProducts();

	Product save(Product product);

}
