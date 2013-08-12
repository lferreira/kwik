package com.kwik.repositories.category.dao;

import static br.com.six2six.fixturefactory.Fixture.from;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.Collection;
import java.util.List;

import javax.persistence.PersistenceException;

import org.hamcrest.Matchers;
import org.jstryker.database.DBUnitHelper;
import org.junit.Before;
import org.junit.Test;

import com.kwik.fixture.load.TemplateLoader;
import com.kwik.helper.TestHelper;
import com.kwik.models.Category;
import com.kwik.models.Product;
import com.kwik.repositories.category.CategoryRepository;

public class CategoryDaoTest extends TestHelper {

	private CategoryRepository categoryRepository;
	
	private Category category;
	
	private Category categoryReturned;
	
	@Before
	public void setUp() {
		
		categoryRepository = new CategoryDao(entityManager);
		
		category = from(Category.class).gimme(TemplateLoader.CategoryTemplate.CATEGORIA_ROUPAS);
	}
	
	@Test
	public void shouldIncludeNewCategory() throws Exception {
		
		categoryReturned = categoryRepository.add(category);
		
		assertThat(categoryReturned.getDescription(), Matchers.equalTo(category.getDescription()));
	}
	
	@Test(expected = PersistenceException.class)
	public void shoulValidateEmptyDescription() throws Exception {
		categoryRepository.add(new Category());
	}
	
	@Test
	public void shouldAssociateProducts() throws Exception {
		
		categoryReturned = categoryRepository.add(category);
		
		Product product = from(Product.class).gimme(TemplateLoader.ProductTemplate.CAMISETA_BRANCA);
		categoryReturned.add(product);
		
		categoryReturned = categoryRepository.update(categoryReturned);
		
		List<Product> products = categoryRepository.findBy(categoryReturned.getId()).getProducts();
		
		assertThat(products.size(), is(1));
	}
	
	@Test
	public void shoulListCategoriesWithProducts() throws Exception {
		
		new DBUnitHelper().cleanInsert("/categories/twoCategoriesWith2Products.xml");
		
		Collection<Category> categories = categoryRepository.listAll();
		assertThat(categories.size(), is(2));
		
		for (Category category : categories) {
			assertThat(category.getProducts().size(), is(2));
		}
	}
	
	@Test
	public void shouldDestroyCategory() throws Exception {
		
		new DBUnitHelper().cleanInsert("/categories/twoCategoriesWith2Products.xml");
		
		Category returned = categoryRepository.findBy(1L);
		
		categoryRepository.destroy(returned);
		
		Collection<Category> categories = categoryRepository.listAll();
		
		assertThat(categories.size(), is(1));
	}
	
}
