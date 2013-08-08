package com.kwik.fixture.load;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;

import com.kwik.fixture.ProdutoSpike;
import com.kwik.models.Product;

public class TemplateLoader {

	public static void loadTemplates() {
		TemplateLoader.ProductTemplate.loadTemplates();
	}

	public static class ProductTemplate {

		public static final String CAMISETA_BRANCA_FOR_SPIKE = "camiseta-branca-for-spike";
		
		public static final String CAMISETA_BRANCA = "camiseta-branca";
		
		public static void loadTemplates() {
			Fixture.of(ProdutoSpike.class).addTemplate(CAMISETA_BRANCA_FOR_SPIKE,
			new Rule() {{ 
				add("id", 1L);
			}});
			Fixture.of(Product.class).addTemplate(CAMISETA_BRANCA,
			new Rule() {{ 
				add("description", "Uma camiseta branca marota");
			}});
		}
	}
}
