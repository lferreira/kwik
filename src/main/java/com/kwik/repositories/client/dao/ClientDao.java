package com.kwik.repositories.client.dao;

import javax.persistence.EntityManager;

import com.kwik.models.Client;
import com.kwik.repositories.client.ClientRepository;

public class ClientDao implements ClientRepository {

	private EntityManager entityManager;
	
	public ClientDao(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public Client add(Client client) {
		Client result = client;
		entityManager.persist(result);
		return result;
	}
}
