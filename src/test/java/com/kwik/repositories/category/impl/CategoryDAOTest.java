package com.kwik.repositories.category.impl;

import static br.com.six2six.fixturefactory.Fixture.from;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import javax.persistence.PersistenceException;

import org.hamcrest.Matchers;
import org.jstryker.database.DBUnitHelper;
import org.junit.Before;
import org.junit.Test;

import com.kwik.fixture.load.TemplateLoader;
import com.kwik.helper.DatabaseTestHelper;
import com.kwik.models.Category;
import com.kwik.models.Product;
import com.kwik.repositories.CategoryRepository;
import com.kwik.repositories.produto.impl.ProductDAO;

public class CategoryDAOTest extends DatabaseTestHelper {

	private CategoryRepository categoryRepository;
	
	private Category category;
	
	private Category categoryReturned;
	
	@Before
	public void setUp() {
		
		categoryRepository = new CategoryDAO(entityManager);
		
		category = from(Category.class).gimme(TemplateLoader.CategoryTemplate.CATEGORIA_ROUPAS);
	}
	
	@Test
	public void shouldIncludeNewCategory() throws Exception {
		
		categoryReturned = categoryRepository.save(category);
		
		assertThat(categoryReturned.getDescription(), Matchers.equalTo(category.getDescription()));
	}
	
	@Test(expected = PersistenceException.class)
	public void shoulValidateEmptyDescription() throws Exception {
		categoryRepository.save(new Category());
	}
	
	@Test
	public void shouldAssociateManyProducts() throws Exception {
		
		categoryReturned = categoryRepository.save(category);
		
		new DBUnitHelper().cleanInsert("/products/tenProducts.xml");

		List<Product> products = new ProductDAO(entityManager).listAll();
		
		categoryReturned.add(products);
		
		Category updated = categoryRepository.update(categoryReturned);
		
		assertThat(updated.getProducts(), is(products));
		
	}

}
