package com.kwik.repositories.client;

import com.kwik.models.Address;

public interface AddressRespository {

	Address findBy(String zipCode);

}
