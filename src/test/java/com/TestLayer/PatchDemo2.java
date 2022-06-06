package com.TestLayer;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PatchDemo2 {
	RequestSpecification httpRequest;
	Response resp;

	@BeforeClass
	public void setUp() {
		RestAssured.baseURI = "http://localhost:3000/posts";
		httpRequest = RestAssured.given();
		httpRequest.header("Content-Type", "application/json");
		httpRequest.body(Utils.updateSpecificEntity("Job", "Automation Test Engineer"));
		resp = httpRequest.patch("/2");
	}

	@Test(priority = 1)
	public void validateStatuCode() {
		Assert.assertEquals(resp.getStatusCode(), 200);
	}

	@Test(priority = 2)
	public void validateStatuLine() {
		Assert.assertEquals(resp.getStatusLine().contains("OK"), true);
	}

	@Test(priority = 3)
	public void validateUpdateFirstName() {
		Assert.assertEquals(resp.getBody().asString().contains("vrushali"), true);
	}

	@Test(priority = 4)
	public void validateContenttypeHeader() {
		Assert.assertEquals(resp.getHeader("Content-Type").contains("json"), true);
	}

}
