package com.kwik.infra.cache.time;

public enum CacheTime {

	THREE_SECONDS(3);
	
	private int time;
	
	private CacheTime(int time) {
		this.time = time;
	}
	
	public int getTime() {
		return time;
	}
}
