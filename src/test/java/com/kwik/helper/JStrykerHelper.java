package com.kwik.helper;

import org.jstryker.database.JPAHelper;

public class JStrykerHelper {

	private static boolean load;

	public static void init() {
		if (!load) {
			load = JPAHelper.entityManagerFactory("test") != null;
		}
	}
}
