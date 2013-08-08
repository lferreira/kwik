package com.kwik.repositories.produto.impl;

import static br.com.six2six.fixturefactory.Fixture.from;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import javax.persistence.PersistenceException;

import org.jstryker.database.DBUnitHelper;
import org.junit.Before;
import org.junit.Test;

import com.kwik.fixture.load.TemplateLoader;
import com.kwik.helper.DatabaseTestHelper;
import com.kwik.models.Product;
import com.kwik.repositories.produto.ProductRepository;

public class ProductDAOTest extends DatabaseTestHelper {

	private ProductRepository produtoRepository;
	
	private Product product;
	
	@Before
	public void setUp() {
		
		produtoRepository = new ProductDAO(entityManager);
		
		product = from(Product.class).gimme(TemplateLoader.ProductTemplate.CAMISETA_BRANCA);
		
	}

	@Test
	public void shouldIncludeNewProduct() throws Exception {
		
		Product returned = produtoRepository.save(product);
		
		assertThat(returned.getDescription(), equalTo(product.getDescription()));
	}

	@Test
	public void shouldUpdateProductDescription() throws Exception {
		
		Product returned = produtoRepository.save(product);
		
		returned.setDescription(descriptionDummy("Na verdade essa camiseta tem uma logo"));
		
		Product updated = produtoRepository.update(returned);
		
		assertThat(updated.getDescription(), equalTo(product.getDescription()));
	}

	@Test
	public void shouldListProducts() throws Exception {
		
		new DBUnitHelper().cleanInsert("/products/tenProducts.xml");
		
		List<Product> products = produtoRepository.listAll();
		
		assertThat(products.size(), equalTo(10));
	}
	
	@Test(expected = PersistenceException.class)
	public void shouldValidateEmptyDescription() throws Exception {
		produtoRepository.save(new Product());
	}
	
	@Test
	public void shouldAddSpecificsForProdut() throws Exception {
		Product returned = produtoRepository.save(product);
		assertThat(returned.getSpecifics(), is(product.getSpecifics()));
	}

	private String descriptionDummy(String description) {
		return description;
	}
}
