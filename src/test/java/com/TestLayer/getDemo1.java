package com.TestLayer;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import io.restassured.RestAssured;


public class getDemo1 {

	@Test
	public void m1() {
		// TODO Auto-generated method stub
		RestAssured.baseURI = "http://localhost:3000/posts";

		given().header("Content-Type", "application/json").when().get("/2").then().log().all();

	}

}
