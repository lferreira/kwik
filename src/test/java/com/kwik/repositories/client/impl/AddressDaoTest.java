package com.kwik.repositories.client.impl;

import static br.com.six2six.fixturefactory.Fixture.from;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.jstryker.database.DBUnitHelper;
import org.junit.Before;
import org.junit.Test;

import com.kwik.fixture.load.TemplateLoader;
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
		
		String zipCode = "01245888";
		Address address = addressRepository.findBy(zipCode);
		
		assertThat(address.getZipCode(), is(zipCode));
	}

	@Test
	public void shouldIncludeAddress() throws Exception {
		
		Address fixture = from(Address.class).gimme(TemplateLoader.AddressTemplate.ENDERECO);
		
		Address returned = addressRepository.add(fixture);
		
		assertThat(returned.getId(), is(notNullValue()));
		
	}
}
