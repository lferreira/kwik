package com.kwik.repositories.client.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

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

	@Override
	public List<Client> listAll() {

		Query query = entityManager.createQuery("FROM " + Client.class.getName());

		@SuppressWarnings("unchecked")
		List<Client> resultList = query.getResultList();

		return resultList;
		
	}
}
