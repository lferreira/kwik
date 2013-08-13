package com.kwik.service.client.impl;

import br.com.caelum.vraptor.ioc.Component;

import com.kwik.infra.notification.Notification;
import com.kwik.infra.security.Encryption;
import com.kwik.infra.secutiry.Password;
import com.kwik.models.Address;
import com.kwik.models.Client;
import com.kwik.repositories.client.ClientRepository;
import com.kwik.service.client.AddressService;
import com.kwik.service.client.ClientService;

@Component
public class ClientServiceImpl implements ClientService {

	private ClientRepository clientRepository;
	
	private Notification notification;
	
	private AddressService addressService;
	
	public ClientServiceImpl(ClientRepository clientRepository, Notification notification, AddressService addressService) {
		this.clientRepository = clientRepository;
		this.notification = notification;
		this.addressService = addressService;
	}

	@Override
	public Client add(Client client, String zipCode) {
		client.setPassword(new Encryption(client.getPassword()).md5());
		client.setAddress(addressService.getAddressBy(zipCode));
		return clientRepository.add(client);
	}

	@Override
	public void resetPassword(Client joao) {
		String newPassword = new Password().generate();
		notification.send(joao, newPassword);
	}

	@Override
	public Address getAddressBy(String zipCode) {
		return addressService.getAddressBy(zipCode);
	}
}
