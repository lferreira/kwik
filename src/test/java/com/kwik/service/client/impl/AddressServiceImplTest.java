package com.kwik.service.client.impl;

import static br.com.six2six.fixturefactory.Fixture.from;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import com.kwik.fixture.load.TemplateLoader;
import com.kwik.helper.TestHelper;
import com.kwik.models.Address;
import com.kwik.repositories.client.AddressRespository;
import com.kwik.service.client.AddressService;

public class AddressServiceImplTest extends TestHelper {

	private AddressService service;
	
	private @Mock AddressRespository repository;
	
	private Address address;
	
	@Before
	public void setUp() {
		
		address = from(Address.class).gimme(TemplateLoader.AddressTemplate.ENDERECO);
		
		service = new AddressServiceImpl(repository) {
			
			@Override
			protected Address fromWebservice(String zipCode) {
				return address;
			}
		};
	}
	
	@Test
	public void shouldFindFromWebService() throws Exception {
		
		when(repository.findBy("02458777")).thenReturn(null);
		
		Address returned = service.getAddressBy(anyString());
		
		assertThat(returned, is(address));
	}
	
	@Test
	public void shouldFindFromDatabse() throws Exception {
		
		Address fixture = from(Address.class).gimme(TemplateLoader.AddressTemplate.ENDERECO);
		
		when(repository.findBy(anyString())).thenReturn(fixture);
		
		Address returned = service.getAddressBy(anyString());
		
		assertThat(returned, is(fixture));
	}
	
}
