package com.kwik.infra.cache.client;

import java.util.Collection;
import java.util.concurrent.TimeoutException;

import net.rubyeye.xmemcached.XMemcachedClient;
import net.rubyeye.xmemcached.exception.MemcachedException;
import br.com.caelum.vraptor.ioc.Component;

import com.kwik.infra.cache.Cache;

@Component
public class CacheClient implements Cache<Object> {

	private XMemcachedClient client;
	
	@Override
	public void put(String key, int time, Object t) {
		try {
			client.add(key, time, t);
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MemcachedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void put(String key, int time, Collection<Object> t) {
		put(key, time, t);
	}

	@Override
	public Object get(String key) {
		try {
			return client.get(key);
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MemcachedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Collection<Object> getList(String key) {
		try {
			return client.get(key);
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MemcachedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void set(XMemcachedClient client) {
		this.client = client;
	}
}
