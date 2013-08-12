package com.kwik.repositories.client.dao;

import javax.persistence.EntityManager;

import br.com.caelum.vraptor.ioc.Component;

import com.kwik.models.Client;
import com.kwik.repositories.client.ClientRepository;

@Component
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
