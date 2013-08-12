package com.kwik.address.service;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class AddressSpike {

	public static void main(String[] args) {
		
		try {
			
			System.setProperty("http.proxyHost", "proxytur.cvc.com.br");
			System.setProperty("http.proxyPort", "8080");
			
			Document doc = Jsoup.connect("http://m.correios.com.br/movel/buscaCepConfirma.do?cepEntrada=03728000&metodo=buscarCep").get();
			
			Elements elements = doc.select("div.caixacampobranco");
			System.out.println(elements.select("span:contains(Logradouro)+span").text());
			
			System.out.println(elements.select("span:contains(Bairro)+span").text());
			
			System.out.println(elements.select("span:contains(Localidade)+span").text());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
