package com.BaseLayer;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class BaseClass {

	public static RequestSpecification httpRequest;

	public static void initialization() {

		RestAssured.baseURI = "http://localhost:3000/posts";
		httpRequest = RestAssured.given();

	}

}
