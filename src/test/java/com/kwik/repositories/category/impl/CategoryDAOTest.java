package com.kwik.repositories.category.impl;

import static br.com.six2six.fixturefactory.Fixture.from;
import static org.junit.Assert.assertThat;

import javax.persistence.PersistenceException;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import com.kwik.fixture.load.TemplateLoader;
import com.kwik.helper.DatabaseTestHelper;
import com.kwik.models.Category;
import com.kwik.repositories.CategoryRepository;

public class CategoryDAOTest extends DatabaseTestHelper {

	private CategoryRepository categoryRepository;
	
	private Category category;
	
	@Before
	public void setUp() {
		
		categoryRepository = new CategoryDAO(entityManager);
		
		category = from(Category.class).gimme(TemplateLoader.CategoryTemplate.CATEGORIA_ROUPAS);
	}
	
	@Test
	public void shouldIncludeNewCategory() throws Exception {
		Category returned = categoryRepository.save(category);
		assertThat(returned.getDescription(), Matchers.equalTo(category.getDescription()));
	}
	
	@Test(expected = PersistenceException.class)
	public void shoulValidateEmptyDescription() throws Exception {
		categoryRepository.save(new Category());
	}
	
}