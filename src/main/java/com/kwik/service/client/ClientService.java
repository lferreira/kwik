package com.kwik.service.client;

import com.kwik.models.Address;
import com.kwik.models.Client;

public interface ClientService {

	Client add(Client client);

	void resetPassword(Client joao);

	Address getAddressBy(String zipCode);
}
