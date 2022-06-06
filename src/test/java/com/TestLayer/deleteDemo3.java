package com.TestLayer;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class deleteDemo3 {

	public static void main(String[] args) {

		RestAssured.baseURI = "http://localhost:3000/posts";

		Response resp = given().header("Content-Type", "application/json")
				.when().delete("/3")
				.then().extract().response();

		System.out.println(resp.getStatusCode());
		System.out.println(resp.getStatusLine());


	}

}
