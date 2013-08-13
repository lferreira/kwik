package com.kwik.controllers;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;

import com.kwik.models.Client;
import com.kwik.service.client.ClientService;

@Resource
public class ClientController {

	private ClientService service;
	
	public ClientController(ClientService service) {
		this.service = service;
	}

	@Get
	public void add() {}
	
	@Post
	public void add(Client client, String zipCode) {
		service.add(client, zipCode);
	}

	public void resetPassword(Client client) {
		service.resetPassword(client);
	}

}
