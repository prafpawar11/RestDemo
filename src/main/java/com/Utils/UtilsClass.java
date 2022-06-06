package com.Utils;

import org.json.simple.JSONObject;

public class UtilsClass {

	public static String addNewEmployee(String fname, String lname, String add, String job) {

		JSONObject json = new JSONObject();

		json.put("FirstName", fname);
		json.put("LastName", lname);
		json.put("Address", add);
		json.put("Job", job);

		return json.toString();
	}

	public static String updateSpecificEntity(String key, String value) {

		JSONObject json = new JSONObject();
		json.put(key, value);

		return json.toString();
	}

}