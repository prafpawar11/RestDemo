package com.TestLayer;

import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PatchDemo {

	public static void main(String[] args) {
		// Patch

		RestAssured.baseURI = "http://localhost:3000/posts";

		RequestSpecification httpRequest = RestAssured.given();

		httpRequest.header("Content-Type", "application/json");

		JSONObject json = new JSONObject();
		json.put("Address", "Mumbai");

		httpRequest.body(json.toString());

		Response resp = httpRequest.patch("/2");

		System.out.println(resp.getStatusCode());
		System.out.println(resp.getStatusLine());

		String actualBody = resp.getBody().asString();
		System.out.println(actualBody);

		Headers allHeaders = resp.getHeaders();

		for (Header abc : allHeaders) {
			System.out.println(abc.getName() + ":::" + abc.getValue());
		}

	}

}
