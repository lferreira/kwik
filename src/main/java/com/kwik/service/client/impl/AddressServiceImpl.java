package com.kwik.service.client.impl;

import static java.lang.String.format;
import static org.jsoup.Jsoup.connect;

import java.io.IOException;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import br.com.caelum.vraptor.ioc.Component;

import com.kwik.infra.exception.KwikCommunicationException;
import com.kwik.models.Address;
import com.kwik.service.client.AddressService;

@Component
public class AddressServiceImpl implements AddressService {

	@Override
	public Address getAddressBy(String zipCode) {
		
		try {
			
			Document doc = connect(format("http://m.correios.com.br/movel/buscaCepConfirma.do?cepEntrada=%s&metodo=buscarCep", zipCode)).get();
			
			Elements elements = doc.select("div.caixacampobranco");
			
			String street = get(elements, "Logradouro");
			
			String district = get(elements, "Bairro");
			
			String location = get(elements, "Localidade");
			
			return new Address().street(street).district(district).location(location).zipCode(zipCode);
			
		} catch (IOException e) {
			throw new KwikCommunicationException("problem communicating with correios webservice", e);
		}
		
	}
	
	private String get(Elements elements, String value) {
		return elements.select(String.format("span:contains(%s)+span", value)).text();
	}
}
