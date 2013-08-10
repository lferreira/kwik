package com.kwik.infra.cache.client;

import java.util.Collection;

import br.com.caelum.vraptor.ioc.Component;

import com.kwik.infra.cache.Cache;
import com.kwik.models.Product;

@Component
public class CacheClient implements Cache<Product> {

	@Override
	public void put(String key, int time, Product t) {
		// TODO Auto-generated method stub
	}

	@Override
	public void put(String key, int time, Collection<Product> t) {
		// TODO Auto-generated method stub
	}

	@Override
	public Product get(String key) {
		return null;
	}

	@Override
	public Collection<Product> getList(String key) {
		return null;
	}
}
