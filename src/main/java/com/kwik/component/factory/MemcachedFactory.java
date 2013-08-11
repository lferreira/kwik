package com.kwik.component.factory;

import java.io.IOException;

import net.rubyeye.xmemcached.XMemcachedClient;
import br.com.caelum.vraptor.ioc.ApplicationScoped;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.ComponentFactory;

import com.kwik.infra.cache.client.CacheClient;

@Component
@ApplicationScoped
public class MemcachedFactory implements ComponentFactory<CacheClient> {

	@Override
	public CacheClient getInstance() {
		
		try {
			
			CacheClient cacheClient = new CacheClient();
			cacheClient.set(new XMemcachedClient("localhost", 11211));
			return cacheClient;
			
		} catch (IOException e1) {
			throw new RuntimeException("problem connecting with memcached!");
		}
	}
}
