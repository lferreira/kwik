package com.kwik.helper;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.AfterClass;
import org.junit.BeforeClass;

public abstract class DatabaseTestHelper {

	protected static EntityManager entityManager;

	protected static EntityTransaction transaction;

	protected static EntityManagerFactory factory;

	@BeforeClass
	public static void setup() {

	    factory = Persistence.createEntityManagerFactory("test");
		entityManager = factory.createEntityManager();
		transaction = entityManager.getTransaction();

		transaction.begin();
	}

	@AfterClass
	public static void after() {
		transaction.commit();
	}
}
