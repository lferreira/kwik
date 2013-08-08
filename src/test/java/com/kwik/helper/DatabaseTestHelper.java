package com.kwik.helper;

import static com.kwik.fixture.load.TemplateLoader.loadTemplatesForFixture;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.mockito.MockitoAnnotations;

public abstract class DatabaseTestHelper {

	protected static EntityManager entityManager;

	protected static EntityTransaction transaction;

	protected static EntityManagerFactory factory;

	@BeforeClass
	public static void beforeClass() {
		
	    factory = Persistence.createEntityManagerFactory("test");
		entityManager = factory.createEntityManager();
		
		loadTemplatesForFixture();
	}

	@Before
	public void before() {
		transaction = entityManager.getTransaction();
		transaction.begin();
		
		MockitoAnnotations.initMocks(this);
	}
	
	@After
	public void tearDown() {
		entityManager.getTransaction().rollback();
	}

}
