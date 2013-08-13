package com.kwik.infra.security;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.kwik.infra.security.Password;

public class PasswordTest {
	
	@Test
	public void shouldGenerateRandomicPassword() throws Exception {

		final String expected = "randomicPassword";
		
		Password password = new Password() {
			@Override
			protected String randomicPassword() {
				return expected;
			}
		};
		assertThat(password.generate(), is(expected));
	}
	
	@Test
	public void randomicPasswordShoulNotBeEmpty() throws Exception {
		
		String generated = new Password().generate();
		
		assertThat(generated , not(""));
		assertThat(generated , notNullValue());
	}
}
