package com.kwik.service.client;

import java.util.List;

import com.kwik.models.Address;
import com.kwik.models.Client;

public interface ClientService {

	Client add(Client client, String zipCode);

	void resetPassword(Client joao);

	Address getAddressBy(String zipCode);

	List<Client> listAll();
}
