package com.kwik.service.client;

import com.kwik.models.Address;

public interface AddressService {

	Address getAddressBy(String zipCode);

}
