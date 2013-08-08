package com.kwik.repositories;

import org.junit.Before;
import org.junit.Test;

import com.kwik.helper.DatabaseTestHelper;

public class ProdutoRepositoryTest extends DatabaseTestHelper {

	private ProdutoRepository produtoRepository;
	
	@Before
	public void setUp() {
		produtoRepository = new ProdutoDAO(entityManager);
	}

	@Test
	public void deveIncluirProduto() throws Exception {
		
	}
	
}
