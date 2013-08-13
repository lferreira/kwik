package com.kwik.repositories.client.impl;

import static br.com.six2six.fixturefactory.Fixture.from;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.List;

import javax.persistence.PersistenceException;

import org.jstryker.database.DBUnitHelper;
import org.junit.Before;
import org.junit.Test;

import com.kwik.fixture.load.TemplateLoader;
import com.kwik.helper.TestHelper;
import com.kwik.models.Client;
import com.kwik.repositories.client.ClientRepository;
import com.kwik.repositories.client.dao.ClientDao;

public class ClientDaoTest extends TestHelper {

	private ClientRepository clientRepository;
	
	private Client joao;
	
	@Before
	public void setUp() {
		clientRepository = new ClientDao(entityManager);
		joao = from(Client.class).gimme(TemplateLoader.ClientTemplate.JOAO);
	}
	
	@Test
	public void shouldIncludeClient() throws Exception {
		
		Client returned = clientRepository.add(joao);
		
		assertThat(returned.getEmail(), equalTo(joao.getEmail()));
	}
	
	@Test(expected = PersistenceException.class)
	public void shouldValidateClient() throws Exception {
		clientRepository.add(new Client());
	}

	@Test
	public void shouldListClients() throws Exception {
		
		new DBUnitHelper().cleanInsert("/clients/twoClients.xml");
		
		List<Client> clients = clientRepository.listAll();
		
		assertThat(clients.size(), equalTo(2));
		
	}
	
}
