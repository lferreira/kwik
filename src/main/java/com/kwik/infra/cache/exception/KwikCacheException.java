package com.kwik.infra.cache.exception;


public class KwikCacheException extends RuntimeException {
	
	private static final long serialVersionUID = 2683936024168506918L;
	
	public KwikCacheException(String message, Throwable e) {
		super(message, e);
	}

}
