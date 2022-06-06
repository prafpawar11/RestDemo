package com.TestLayer;

import org.json.simple.JSONObject;

public class Utils {

	public static String updateSpecificEntity(String key, String value) {

		JSONObject json = new JSONObject();
		json.put(key, value);

		return json.toString();
	}

}
