package com.kwik.service.impl;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.vraptor.ioc.Component;

import com.google.common.collect.Lists;
import com.kwik.infra.cache.Cache;
import com.kwik.models.Product;
import com.kwik.repositories.product.ProductRepository;
import com.kwik.service.ProductService;

@Component
public class ProductServiceImpl implements ProductService {

	private static final String KEY = "allProducts";

	private static final int ONE_HOUR = 3600;

	private Cache<Product> cache;

	private ProductRepository repository;
	
	public ProductServiceImpl(ProductRepository repository, Cache<Product> cacheClient) {
		super();
		this.cache = cacheClient;
		this.repository = repository;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> listAll() {
		
		List<Product> products = Lists.newArrayList();
		
		Object cached = cache.get(KEY);
		
		if (cached != null) {
			
			products  = (ArrayList<Product>) cached;
			
		} else {
			
			products = repository.listAll();
			cache.put(KEY, ONE_HOUR, products);
		}
		
		return products;
	}

	@Override
	public Product add(Product product) {
		return repository.add(product);
	}
}
