package com.kwik.controllers;

import static br.com.caelum.vraptor.view.Results.json;
import static br.com.caelum.vraptor.view.Results.status;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

import com.kwik.models.Address;
import com.kwik.service.client.AddressService;

@Resource
public class AddressController {
	
	private AddressService service;

	private Result result;
	
	public AddressController(AddressService service, Result result) {
		this.service = service;
		this.result = result;
	}

	@Get
	public void get(String zipCode) {
		
		Address address = service.getAddressBy(zipCode);
		
		if (address == null) {
			result.use(status()).noContent();
		} else {
			result.use(json()).from(address).serialize();
		}
	}
}
