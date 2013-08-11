package com.kwik.repositories.product.dao;

import static br.com.six2six.fixturefactory.Fixture.from;
import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import javax.persistence.PersistenceException;

import org.jstryker.database.DBUnitHelper;
import org.junit.Before;
import org.junit.Test;

import com.kwik.fixture.load.TemplateLoader;
import com.kwik.helper.TestHelper;
import com.kwik.models.Product;
import com.kwik.repositories.product.ProductRepository;

public class ProductDaoTest extends TestHelper {

	private ProductRepository productRepository;
	
	private Product product;
	
	@Before
	public void setUp() {
		
		productRepository = new ProductDao(entityManager);
		
		product = from(Product.class).gimme(TemplateLoader.ProductTemplate.CAMISETA_BRANCA);
	}

	@Test
	public void shouldIncludeNewProduct() throws Exception {
		
		Product returned = productRepository.add(product);
		
		assertThat(returned.getDescription(), equalTo(product.getDescription()));
	}

	@Test
	public void shouldUpdateProductDescription() throws Exception {
		
		Product returned = productRepository.add(product);
		
		returned.setDescription(descriptionDummy("Na verdade essa camiseta tem uma logo"));
		
		Product updated = productRepository.update(returned);
		
		assertThat(updated.getDescription(), equalTo(product.getDescription()));
	}

	@Test
	public void shouldListProducts() throws Exception {
		
		new DBUnitHelper().cleanInsert("/products/tenProducts.xml");
		
		List<Product> products = productRepository.listAll();
		
		assertThat(products.size(), equalTo(10));
	}
	
	@Test(expected = PersistenceException.class)
	public void shouldValidateEmptyDescription() throws Exception {
		productRepository.add(new Product());
	}
	
	@Test
	public void shouldAddSpecificsForProdut() throws Exception {
		Product returned = productRepository.add(product);
		assertThat(returned.getSpecifics(), is(product.getSpecifics()));
	}
	
	@Test
	public void shouldListByIds() throws Exception {
		
		new DBUnitHelper().cleanInsert("/products/tenProducts.xml");
		
		List<Long> ids = asList(1L, 2L, 3L);
		
		List<Product> products = productRepository.findBy(ids);
		
		assertThat(products.size(), is(3));
	}
	
	private String descriptionDummy(String description) {
		return description;
	}
}
