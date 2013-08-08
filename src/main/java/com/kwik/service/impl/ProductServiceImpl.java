package com.kwik.service.impl;

import java.util.ArrayList;
import java.util.List;

import net.spy.memcached.MemcachedClientIF;

import com.google.common.collect.Lists;
import com.kwik.models.Product;
import com.kwik.repositories.product.ProductRepository;
import com.kwik.service.ProductsService;

public class ProductServiceImpl implements ProductsService {

	private static final String KEY = "allProducts";

	private static final int ONE_HOUR = 3600;

	private MemcachedClientIF cacheClient;

	private ProductRepository repository;
	
	public ProductServiceImpl(ProductRepository repository, MemcachedClientIF cacheClient) {
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
			cacheClient.add(KEY, ONE_HOUR, products);
		}
		
		return products;
	}
}
