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
import com.kwik.helper.DatabaseTestHelper;
import com.kwik.models.Category;
import com.kwik.models.Product;
import com.kwik.repositories.category.CategoryRepository;
import com.kwik.repositories.product.dao.ProductDao;

public class CategoryDaoTest extends DatabaseTestHelper {

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
		
		new DBUnitHelper().cleanInsert("/products/tenProducts.xml");

		List<Product> products = new ProductDao(entityManager).listAll();
		
		categoryReturned.add(products);
		
		Category updated = categoryRepository.update(categoryReturned);
		
		assertThat(updated.getProducts(), is(products));
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
}
