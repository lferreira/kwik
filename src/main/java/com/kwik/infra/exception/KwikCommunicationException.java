package com.kwik.infra.exception;


public class KwikCommunicationException extends RuntimeException {

	private static final long serialVersionUID = 2085232855539649247L;
	
	public KwikCommunicationException(String message, Throwable e) {
		super(message, e);
	}

}
