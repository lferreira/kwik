package com.kwik.repositories.client;

import java.util.List;

import com.kwik.models.Client;

public interface ClientRepository {

	Client add(Client client);

	List<Client> listAll();

}
