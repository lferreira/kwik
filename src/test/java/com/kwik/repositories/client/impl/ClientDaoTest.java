package com.kwik.repositories.client.impl;

import static br.com.six2six.fixturefactory.Fixture.from;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import javax.persistence.PersistenceException;

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
	public void shoulIncludeClient() throws Exception {
		
		Client returned = clientRepository.add(joao);
		
		assertThat(returned.getEmail(), equalTo(joao.getEmail()));
	}
	
	@Test(expected = PersistenceException.class)
	public void shouldValidateClient() throws Exception {
		clientRepository.add(new Client());
	}
	
}
