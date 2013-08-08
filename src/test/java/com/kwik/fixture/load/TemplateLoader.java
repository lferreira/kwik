package com.kwik.fixture.load;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;

import com.kwik.fixture.ProdutoSpike;

public class TemplateLoader {

	public static void loadTemplates() {
		TemplateLoader.ProdutoTemplate.loadTemplates();
	}

	public static class ProdutoTemplate {

		public static final String CAMISETA_P_FOR_SPIKE = "camiseta-p";

		public static void loadTemplates() {
			Fixture.of(ProdutoSpike.class).addTemplate(CAMISETA_P_FOR_SPIKE,
			new Rule() {{ 
				add("id", 1L);
			}});
		}
	}
}
