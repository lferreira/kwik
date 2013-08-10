package com.kwik.infra.cache.client;

import java.util.Collection;

import br.com.caelum.vraptor.ioc.ApplicationScoped;
import br.com.caelum.vraptor.ioc.Component;

import com.kwik.infra.cache.Cache;

@Component
@ApplicationScoped
public class CacheClient implements Cache<Object> {

	
	@Override
	public void put(String key, int time, Object t) {
	
	}

	@Override
	public void put(String key, int time, Collection<Object> t) {

	}

	@Override
	public Object get(String key) {
		return null;
	}

	@Override
	public Collection<Object> getList(String key) {
		return null;
	}
}
