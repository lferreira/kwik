package com.kwik.repositories;

import static br.com.six2six.fixturefactory.Fixture.from;
import static com.kwik.fixture.load.TemplateLoader.loadTemplates;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.kwik.fixture.load.TemplateLoader;
import com.kwik.helper.DatabaseTestHelper;
import com.kwik.models.Product;
import com.kwik.repositories.produto.ProductRepository;

public class ProductRepositoryTest extends DatabaseTestHelper {

	private ProductRepository produtoRepository;
	
	private Product product;
	
	@Before
	public void setUp() {
		produtoRepository = new ProductDAO(entityManager);
		loadTemplates();
		
		product = from(Product.class).gimme(TemplateLoader.ProductTemplate.CAMISETA_BRANCA);
	}

	@Test
	public void shouldIncludeNewProduct() throws Exception {
		Product returned = produtoRepository.save(product);
		assertThat(product.getDescription(), equalTo(returned.getDescription()));
	}
}
