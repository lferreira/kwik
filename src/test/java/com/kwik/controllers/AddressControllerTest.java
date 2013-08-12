package com.kwik.controllers;

import static br.com.caelum.vraptor.view.Results.json;
import static br.com.caelum.vraptor.view.Results.status;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Spy;

import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.util.test.MockResult;

import com.kwik.helper.TestHelper;
import com.kwik.models.Address;
import com.kwik.service.client.AddressService;

public class AddressControllerTest extends TestHelper {

	private AddressController controller;
	
	private @Mock AddressService service;
	
	private @Spy Result result = new MockResult();
	
	@Before
	public void setUp() {
		controller = new AddressController(service, result);
	}
	
	@Test
	public void shouldGetAddress() throws Exception {
		
		String zipCode = "00000000";
		
		when(service.getAddressBy(zipCode)).thenReturn(new Address());
		
		controller.get(zipCode);
		
		verify(result).use(json());
		
	}
	
	@Test
	public void shouldNotReturnValue() throws Exception {
		
		String zipCode = "00000000";
		
		when(service.getAddressBy(zipCode)).thenReturn(null);
		
		controller.get(zipCode);
		
		verify(result).use(status());
		
	}
}
