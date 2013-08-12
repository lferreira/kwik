package com.kwik.repositories.client.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.com.caelum.vraptor.ioc.Component;

import com.kwik.models.Address;
import com.kwik.repositories.client.AddressRespository;

@Component
public class AddressDao implements AddressRespository {

	private EntityManager entityManager;
	
	public AddressDao(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public Address findBy(String zipCode) {
		Query query = entityManager.createQuery(" FROM " + Address.class.getName() + " a WHERE a.zipCode = :zipCode ");
		query.setParameter("zipCode", zipCode);
		
		Address address = null;
		
		try {
			
			return (Address) query.getSingleResult();
			
		} catch (NoResultException e) {}	
		
		return address;
	}

}
