package com.ui.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtililty {

	private static Properties prop = new Properties();
	private static String path = "config/QA.properties";
	private static String env;
	static {

		if (System.getProperty("env") == null) {
			System.err.println("Env variable is not set, setting it to QA Default");
		}
		env = System.getProperty("env", "QA");
		switch (env.trim().toLowerCase()) {
		case "dev" -> path = "config/DEV.properties";
		case "qa" -> path = "config/QA.properties";
		case "uat" -> path = "config/UAT.properties";
		default -> System.err.println("Please provide a valid environment");
		}

		InputStream stream = Thread.currentThread().getContextClassLoader().getResourceAsStream(path);
		try {
			prop.load(stream);
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (path == null) {
			throw new RuntimeException("Not able to find porperties file on path " + path);
		}
	}

	private PropertiesUtililty() {

	}

	public static String getProperty(String propertyName) {
		return prop.getProperty(propertyName);
	}

}
