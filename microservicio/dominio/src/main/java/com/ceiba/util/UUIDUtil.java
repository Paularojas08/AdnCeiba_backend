package com.ceiba.util;

import java.util.UUID;

public class UUIDUtil {
	
	private UUIDUtil() {}
	
	public static String generarUUID() {

		return UUID.randomUUID().toString();
	}
}
