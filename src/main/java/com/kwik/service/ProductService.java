package com.kwik.service;

import java.util.List;

import com.kwik.models.Product;

public interface ProductService {

	List<Product> listAll();

	Product add(Product product);

}
