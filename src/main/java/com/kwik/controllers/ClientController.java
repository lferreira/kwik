package com.kwik.controllers;

import static br.com.caelum.vraptor.view.Results.json;

import java.util.List;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;

import com.kwik.models.Client;
import com.kwik.service.client.ClientService;

@Resource
public class ClientController {

	private ClientService service;
	
	private Result result;
	
	public ClientController(ClientService service, Result result) {
		this.result = result;
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

	@Get
	public void list() {

		List<Client> list = service.listAll();
		
		if (list.isEmpty()) {
			result.use(Results.status()).noContent();
		} else {
			result.use(json()).from(list).serialize();
		}
	}
}
