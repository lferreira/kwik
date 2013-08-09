package com.kwik.controllers;

import static org.junit.Assert.*;
import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Spy;

import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.util.test.MockResult;

public class IndexControllerTest {

	private @Spy Result result = new MockResult();
	
	private IndexController controller;
	
	@Before
	public void setUp() throws Exception {
		controller = new IndexController(result);
	}
	
	@Test
	public void shouldListIncludedProducts() throws Exception {

		controller.index();
		
	}
	
}
