package com.TestLayer;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class deleteDemo2 {

	public static void main(String[] args) {

		RestAssured.baseURI = "http://localhost:3000/posts";

		RequestSpecification httpRequest = RestAssured.given();

		for (int i = 3; i <= 20; i++) 
		{
			Response resp = httpRequest.delete(Integer.toString(i));
			System.out.println(resp.getStatusCode());

		}

	}

}
