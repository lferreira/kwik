package com.kwik.controllers;

import br.com.caelum.vraptor.Resource;

import com.kwik.models.Client;
import com.kwik.service.client.ClientService;

@Resource
public class ClientController {

	private ClientService service;
	
	public ClientController(ClientService service) {
		this.service = service;
	}

	public void add(Client client) {
		service.add(client);
	}

	public void resetPassword(Client client) {
		service.resetPassword(client);
	}

}
