package com.kwik.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.Lists;
import com.kwik.infra.cache.Cache;
import com.kwik.models.Product;
import com.kwik.repositories.product.ProductRepository;
import com.kwik.service.ProductService;

public class ProductServiceImpl implements ProductService {

	private static final String KEY = "allProducts";

	private static final int ONE_HOUR = 3600;

	private Cache<Product> cacheClient;

	private ProductRepository repository;
	
	public ProductServiceImpl(ProductRepository repository, Cache<Product> cacheClient) {
		super();
		this.cacheClient = cacheClient;
		this.repository = repository;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> listProducts() {
		
		List<Product> products = Lists.newArrayList();
		
		Object cached = cacheClient.get(KEY);
		
		if (cached != null) {
			
			products  = (ArrayList<Product>) cached;
			
		} else {
			
			products = repository.listAll();
			cacheClient.put(KEY, ONE_HOUR, products);
		}
		
		return products;
	}

	@Override
	public Product save(Product product) {
		return repository.save(product);
	}
}
