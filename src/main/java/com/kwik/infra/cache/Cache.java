package com.kwik.infra.cache;

import java.util.Collection;

public interface Cache<T> {

	void put(String key, int time, T t);
	
	void put(String key, int time, Collection<T> t);
	
	T get(String key);
	
	Collection<T> getList(String key);
	
}
