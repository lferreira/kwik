package com.kwik.controllers;

import static br.com.caelum.vraptor.view.Results.json;
import static br.com.six2six.fixturefactory.Fixture.from;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Spy;

import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.util.test.MockResult;

import com.kwik.fixture.load.TemplateLoader;
import com.kwik.helper.TestHelper;
import com.kwik.models.Client;
import com.kwik.service.client.ClientService;

public class ClientControllerTest extends TestHelper {

	private @Spy Result result = new MockResult();
	
	private @Mock ClientService service;
	
	private ClientController controller;

	private Client joao;
	
	@Before
	public void setUp() {
		
		controller = new ClientController(service, result);
		
		joao = from(Client.class).gimme(TemplateLoader.ClientTemplate.JOAO);
	}
	
	@Test
	public void shouldIncludeNewClient() throws Exception {
		
		controller.add(joao, "");
		
		verify(service).add(joao, "");
	}
	
	@Test
	public void shouldResetPassword() throws Exception {
		
		controller.resetPassword(joao);
		
		verify(service).resetPassword(joao);
	}
	
	@Test
	public void shouldListClients() throws Exception {
		
		List<Client> clients = from(Client.class).gimme(4, TemplateLoader.ClientTemplate.JOAO);
		
		when(service.listAll()).thenReturn(clients);
		
		controller.list();
		
		verify(result).use(json());
	}
	
}
