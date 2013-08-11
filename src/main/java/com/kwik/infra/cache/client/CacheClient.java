package com.kwik.infra.cache.client;

import java.util.Collection;
import java.util.concurrent.TimeoutException;

import net.rubyeye.xmemcached.XMemcachedClient;
import net.rubyeye.xmemcached.exception.MemcachedException;
import br.com.caelum.vraptor.ioc.ApplicationScoped;
import br.com.caelum.vraptor.ioc.Component;

import com.kwik.infra.cache.Cache;
import com.kwik.infra.cache.exception.KwikCacheException;

@Component
@ApplicationScoped
public class CacheClient implements Cache<Object> {

	private static final String CACHE_SERVER_MUST_BE_STOPED = "cache server must be stoped";

	private static final String COMMUNICATION_LOST = "communication lost";

	private static final String TIMEOUT = "timeout!";
	
	private XMemcachedClient client;
	
	public CacheClient(XMemcachedClient client) {
		super();
		this.client = client;
	}

	@Override
	public void put(String key, int time, Object t) {
		try {
			client.add(key, time, t);
		} catch (TimeoutException e) {
			throw new KwikCacheException(TIMEOUT, e);
		} catch (InterruptedException e) {
			throw new KwikCacheException(COMMUNICATION_LOST, e);
		} catch (MemcachedException e) {
			throw new KwikCacheException(CACHE_SERVER_MUST_BE_STOPED, e);
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
			throw new KwikCacheException(TIMEOUT, e);
		} catch (InterruptedException e) {
			throw new KwikCacheException(COMMUNICATION_LOST, e);
		} catch (MemcachedException e) {
			throw new KwikCacheException(CACHE_SERVER_MUST_BE_STOPED, e);
		}
	}

	@Override
	public Collection<Object> getList(String key) {
		try {
			return client.get(key);
		} catch (TimeoutException e) {
			throw new KwikCacheException(TIMEOUT, e);
		} catch (InterruptedException e) {
			throw new KwikCacheException(COMMUNICATION_LOST, e);
		} catch (MemcachedException e) {
			throw new KwikCacheException(CACHE_SERVER_MUST_BE_STOPED, e);
		}
	}
}
