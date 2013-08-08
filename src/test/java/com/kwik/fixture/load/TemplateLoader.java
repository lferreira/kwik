package com.kwik.fixture.load;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;

import com.kwik.fixture.ProdutoSpike;
import com.kwik.models.Category;
import com.kwik.models.Product;
import com.kwik.models.Specifics;

public class TemplateLoader {

	public static void loadTemplatesForFixture() {
		TemplateLoader.ProductTemplate.loadTemplates();
		TemplateLoader.CategoryTemplate.loadTemplates();
		TemplateLoader.SpecificsTemplate.loadTemplates();
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
				add("value", 100.00);
				add("specifics", one(Specifics.class, SpecificsTemplate.ESPECIFICACOES_CAMISETA));
			}});
		}
	}
	
	public static class CategoryTemplate {
		
		public static final String CATEGORIA_ROUPAS = "categoria-roupas";
		
		public static void loadTemplates() {
			Fixture.of(Category.class).addTemplate(CATEGORIA_ROUPAS,
			new Rule() {{ 
				add("description", "Roupas");
			}});
		}
	}
	
	public static class SpecificsTemplate {
		
		public static final String ESPECIFICACOES_CAMISETA = "especificacoes-camiseta";
		
		public static void loadTemplates() {
			Fixture.of(Specifics.class).addTemplate(ESPECIFICACOES_CAMISETA,
			new Rule() {{ 
				add("brand", "Hering");
				add("size", "tamanho P");
			}});
		}
	}
}
