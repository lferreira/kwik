package com.kwik.infra.security;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encryption {

	private String password;
	
	private MessageDigest messageDigest;
	
	public Encryption(String password) {
		this.password = password;
	
	}
	
	public String md5() {
		
		try {
			
			messageDigest = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException("problem with algorithm md5");
		}
		
		messageDigest.update(password.getBytes(), 0, password.length());
		return new BigInteger(1, messageDigest.digest()).toString(16);
	}
}
