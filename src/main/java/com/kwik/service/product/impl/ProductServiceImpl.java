package com.kwik.service.product.impl;

import static com.kwik.infra.cache.time.CacheTime.THREE_SECONDS;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.vraptor.ioc.Component;

import com.google.common.collect.Lists;
import com.kwik.infra.cache.Cache;
import com.kwik.models.Product;
import com.kwik.repositories.product.ProductRepository;
import com.kwik.service.product.ProductService;

@Component
public class ProductServiceImpl implements ProductService {

	private static final String KEY = "allProducts";

	private Cache<Object> cache;

	private ProductRepository repository;
	
	public ProductServiceImpl(ProductRepository repository, Cache<Object> cache) {
		super();
		this.cache = cache;
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
			cache.put(KEY, THREE_SECONDS.getTime(), products);
		}
		
		return products;
	}

	@Override
	public Product add(Product product) {
		return repository.add(product);
	}
}
