package com.kwik.controllers;

import static br.com.six2six.fixturefactory.Fixture.from;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import com.kwik.fixture.load.TemplateLoader;
import com.kwik.helper.TestHelper;
import com.kwik.models.Client;
import com.kwik.service.client.ClientService;

public class ClientControllerTest extends TestHelper {

	private @Mock ClientService service;
	
	private ClientController controller;

	private Client joao;
	
	@Before
	public void setUp() {
		
		controller = new ClientController(service);
		
		joao = from(Client.class).gimme(TemplateLoader.ClientTemplate.JOAO);
	}
	
	@Test
	public void shouldIncludeNewClient() throws Exception {
		
		controller.add(joao);
		
		verify(service).add(joao);
	}
	
	@Test
	public void shouldResetPassword() throws Exception {
		
		controller.resetPassword(joao);
		
		verify(service).resetPassword(joao);
	}
}
