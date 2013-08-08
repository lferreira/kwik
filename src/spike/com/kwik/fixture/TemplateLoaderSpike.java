package com.kwik.fixture;

import static com.kwik.fixture.load.TemplateLoader.loadTemplates;
import static junit.framework.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import br.com.six2six.fixturefactory.Fixture;

import com.kwik.fixture.load.TemplateLoader.ProdutoTemplate;

public class TemplateLoaderSpike {

	@Before
	public void setUp() {
		loadTemplates();
	}
	
	@Test
	public void fixtureFactoryReadyToWork() throws Exception {
		ProdutoSpike produto = Fixture.from(ProdutoSpike.class).gimme(ProdutoTemplate.CAMISETA_P_FOR_SPIKE);
		assertNotNull(produto);
	}
	
}
