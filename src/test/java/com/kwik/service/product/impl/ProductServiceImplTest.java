package com.kwik.service.product.impl;

import static br.com.six2six.fixturefactory.Fixture.from;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.List;

import net.spy.memcached.MemcachedClientIF;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import br.com.six2six.fixturefactory.Fixture;

import com.kwik.fixture.load.TemplateLoader;
import com.kwik.helper.DatabaseTestHelper;
import com.kwik.models.Product;
import com.kwik.repositories.product.ProductRepository;
import com.kwik.service.ProductService;
import com.kwik.service.impl.ProductServiceImpl;

public class ProductServiceImplTest extends DatabaseTestHelper {

	private @Mock MemcachedClientIF cacheClient;

	private @Mock ProductRepository repository;
	
	private ProductService productService;
	
	@Before
	public void setUp() {
		
		initMocks(this);
		
		productService = new ProductServiceImpl(repository, cacheClient);
	}
	
	@Test
	public void shouldIncludeNewProduct() throws Exception {
		
		Product product = from(Product.class).gimme(TemplateLoader.ProductTemplate.CAMISETA_BRANCA);
		
		productService.save(product);
		
		verify(repository).save(product);
	}
	
	@Test
	public void shouldListProducts() throws Exception {
		
		productService.listProducts();
		
		verify(repository).listAll();
	}
	
	@Test
	public void shouldAddProductsInCache() throws Exception {
		
		when(cacheClient.get(anyString())).thenReturn(null);
		
		productService.listProducts();
		
		verify(cacheClient).add(anyString(), anyInt(), anyObject());
	}
	
	@Test
	public void shouldGetProductsFromCache() throws Exception {
		
		List<Object> products = Fixture.from(Product.class).gimme(10, TemplateLoader.ProductTemplate.CAMISETA_BRANCA);
		
		when(cacheClient.get(anyString())).thenReturn(products);
		
		verify(cacheClient, never()).add(anyString(), anyInt(), anyObject());;
	}
}
