package com.kwik.fixture;

import static com.kwik.fixture.load.TemplateLoader.loadTemplatesForFixture;
import static junit.framework.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import br.com.six2six.fixturefactory.Fixture;

import com.kwik.fixture.load.TemplateLoader.ProductTemplate;

public class TemplateLoaderSpike {

	@Before
	public void setUp() {
		loadTemplatesForFixture();
	}
	
	@Test
	public void fixtureFactoryReadyToWork() throws Exception {
		ProdutoSpike produto = Fixture.from(ProdutoSpike.class).gimme(ProductTemplate.CAMISETA_BRANCA_FOR_SPIKE);
		assertNotNull(produto);
	}
	
}
