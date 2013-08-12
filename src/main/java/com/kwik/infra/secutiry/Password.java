package com.kwik.infra.secutiry;

import java.math.BigInteger;
import java.security.SecureRandom;

public class Password {

	public String generate() {
		return randomicPassword();
	}

	protected String randomicPassword() {
		SecureRandom random = new SecureRandom();
		return new BigInteger(130, random).toString(32);
	}
}
