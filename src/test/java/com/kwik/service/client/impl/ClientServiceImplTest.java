package com.kwik.service.client.impl;

import static br.com.six2six.fixturefactory.Fixture.from;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import com.kwik.fixture.load.TemplateLoader;
import com.kwik.helper.TestHelper;
import com.kwik.infra.notification.Notification;
import com.kwik.models.Client;
import com.kwik.repositories.client.ClientRepository;
import com.kwik.service.client.AddressService;
import com.kwik.service.client.ClientService;

public class ClientServiceImplTest extends TestHelper {

	private @Mock ClientRepository clientRepository;
	
	private @Mock Notification notification;
	
	private @Mock AddressService addressService;
	
	private ClientService clientService;
	
	private Client joao;
			
	@Before
	public void setUp() {
		
		clientService = new ClientServiceImpl(clientRepository, notification, addressService);
		
		joao = from(Client.class).gimme(TemplateLoader.ClientTemplate.JOAO);
	}
	
	@Test
	public void shouldIncludeNewClient() throws Exception {
		
		clientService.add(joao, "");
		
		verify(clientRepository).add(joao);
	}
	
	@Test
	public void shouldEncryptPassword() throws Exception {
		
		String password = joao.getPassword();
		
		when(clientRepository.add(joao)).thenReturn((Client) from(Client.class).gimme(TemplateLoader.ClientTemplate.JOAO_COM_SENHA_CRIPTOGRAFADA));
		
		Client returned = clientService.add(joao, "");
		
		assertThat(password, not(returned.getPassword()));
	}
	
	@Test
	public void shouldNotifyClientWhenResetPassword() throws Exception {
		
		clientService.resetPassword(joao);
		
		verify(notification).send(any(Client.class), anyString());
	}
	
	@Test
	public void shouldGetAdressFromCorreios() throws Exception {
		clientService.getAddressBy(anyString());
		verify(addressService).getAddressBy(anyString());
	}
}
