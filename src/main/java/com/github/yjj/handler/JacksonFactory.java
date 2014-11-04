package com.github.yjj.handler;

import org.codehaus.jackson.map.ObjectMapper;

public class JacksonFactory {

	private JacksonFactory() {

	}

	private static ObjectMapper objectMapper = null;

	public static ObjectMapper getObjectMapper() {
		if (objectMapper == null) {
			objectMapper = new ObjectMapper();
		}
		return objectMapper;
	}

}
