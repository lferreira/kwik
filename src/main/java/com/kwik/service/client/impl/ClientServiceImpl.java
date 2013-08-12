package com.kwik.service.client.impl;

import com.kwik.infra.security.Encryption;
import com.kwik.models.Client;
import com.kwik.repositories.client.ClientRepository;
import com.kwik.service.client.ClientService;

public class ClientServiceImpl implements ClientService {

	private ClientRepository clientRepository;
	
	public ClientServiceImpl(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}

	@Override
	public Client add(Client client) {
		client.setPassword(new Encryption(client.getPassword()).md5());
		return clientRepository.add(client);
	}

}
