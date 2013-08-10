package com.kwik.helper;

import static com.kwik.fixture.load.TemplateLoader.loadTemplatesForFixture;
import static org.mockito.MockitoAnnotations.initMocks;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;

public abstract class TestHelper {

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
		
		initMocks(this);
	}
	
	@After
	public void tearDown() {
		entityManager.getTransaction().rollback();
	}

}
