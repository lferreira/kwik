package com.kwik.repositories.client.impl;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.jstryker.database.DBUnitHelper;
import org.junit.Before;
import org.junit.Test;

import com.kwik.helper.TestHelper;
import com.kwik.models.Address;
import com.kwik.repositories.client.AddressRespository;
import com.kwik.repositories.client.dao.AddressDao;

public class AddressDaoTest extends TestHelper {

	private AddressRespository addressRepository;
	
	@Before
	public void setUp() {
		addressRepository = new AddressDao(entityManager);
	}
	
	@Test
	public void shouldFindZipCode() throws Exception {
		new DBUnitHelper().cleanInsert("/clients/address.xml");
		
		Address address = addressRepository.findBy("01245888");
		
		assertThat(address.getId(), is(1L));
	}
	
}
