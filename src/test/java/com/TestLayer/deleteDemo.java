package com.TestLayer;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class deleteDemo {

	public static void main(String[] args) {

		RestAssured.baseURI = "http://localhost:3000/posts";

		RequestSpecification httpRequest = RestAssured.given();

		Response resp = httpRequest.delete("/21");

		System.out.println(resp.getStatusCode());
		System.out.println(resp.getStatusLine());

		Headers all = resp.headers();

		for (Header abc : all) {
			System.out.println(abc.getName() + ":::" + abc.getValue());
		}

	}

}
