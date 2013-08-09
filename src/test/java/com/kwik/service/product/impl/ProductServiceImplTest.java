package com.kwik.service.product.impl;

import static br.com.six2six.fixturefactory.Fixture.from;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import br.com.six2six.fixturefactory.Fixture;

import com.kwik.fixture.load.TemplateLoader;
import com.kwik.helper.DatabaseTestHelper;
import com.kwik.infra.cache.Cache;
import com.kwik.models.Product;
import com.kwik.repositories.product.ProductRepository;
import com.kwik.service.ProductService;
import com.kwik.service.impl.ProductServiceImpl;

public class ProductServiceImplTest extends DatabaseTestHelper {

	private @Mock Cache<Product> cache;

	private @Mock ProductRepository repository;
	
	private ProductService productService;
	
	@Before
	public void setUp() {
		productService = new ProductServiceImpl(repository, cache);
	}
	
	@Test
	public void shouldIncludeNewProduct() throws Exception {
		
		Product product = from(Product.class).gimme(TemplateLoader.ProductTemplate.CAMISETA_BRANCA);
		
		productService.add(product);
		
		verify(repository).add(product);
	}
	
	@Test
	public void shouldListProducts() throws Exception {
		
		productService.listProducts();
		
		verify(repository).listAll();
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void shouldAddProductsInCache() throws Exception {
		
		when(cache.get(anyString())).thenReturn(null);
		
		productService.listProducts();
		
		verify(cache).put(anyString(), anyInt(), (ArrayList<Product>) anyObject());
	}
	
	@Test
	public void shouldGetProductsFromCache() throws Exception {
		
		List<Product> products = Fixture.from(Product.class).gimme(10, TemplateLoader.ProductTemplate.CAMISETA_BRANCA);
		
		when(cache.getList(anyString())).thenReturn(products);
		
		verify(cache, never()).put(anyString(), anyInt(), (Product) anyObject());;
	}
}
