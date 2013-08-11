package com.kwik.infra.cache.factory;

import java.io.IOException;

import net.rubyeye.xmemcached.XMemcachedClient;
import br.com.caelum.vraptor.ioc.ApplicationScoped;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.ComponentFactory;

@Component
@ApplicationScoped
public class CacheClientFactory implements ComponentFactory<XMemcachedClient> {

	@Override
	public XMemcachedClient getInstance() {
		
		try {
			return new XMemcachedClient("localhost", 11211);
		} catch (IOException e1) {
			throw new RuntimeException("problem connecting with memcached!");
		}
	}
}
