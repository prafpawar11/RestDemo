package com.TestLayer;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.BaseLayer.BaseClass;
import com.Utils.UtilsClass;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class EndToEndPIMPageFlow extends BaseClass {
	public static Response resp;
	public static String actualId;

	@BeforeClass
	public void setUP() {
		BaseClass.initialization();
		httpRequest.header("Content-Type", "application/json");
		httpRequest.body(UtilsClass.addNewEmployee("vrushali@gmail.com", "Vrushali", "Solanke", "abc.png"));
		resp = httpRequest.post();
	}

	@Test(priority = 1)
	public void validatePOSTReqStatusCode() {
		Assert.assertEquals(resp.getStatusCode(), 201);

	}

	@Test(priority = 2)
	public void validatePOSTReqStatusLine() {
		Assert.assertEquals(resp.getStatusLine(), "HTTP/1.1 201 Created");

	}

	@Test(priority = 3)
	public void validatePOSTReqContentHeader() {
		Assert.assertEquals(resp.getHeader("Content-Type"), "application/json; charset=utf-8");

	}

	@Test(priority = 4)
	public void validatePOSTReqCaptureId() {
		actualId = resp.jsonPath().getString("id");
		System.out.println(actualId);

	}

	@Test(priority = 5)
	public void getNewlyCreatedUser() {
		resp = httpRequest.get(actualId);
		Assert.assertEquals(resp.getStatusCode(), 200);
	}

	@Test(priority = 6)
	public void validateStatusLineForGet() {
		Assert.assertEquals(resp.getStatusLine().contains("OK"), true);
	}

	@Test(priority = 7)
	public void validateResponseBody() {
		Assert.assertEquals(resp.body().asString().contains("Vrushali"), true);
	}

	@Test(priority = 8)
	public void validateContentTypeHeaderUsingGet() {
		Assert.assertEquals(resp.getHeader("Content-Type").contains("json"), true);
	}

	@Test(priority = 9)
	public void updateWholeEntity() {
		System.out.println(resp.getBody().asString());
		httpRequest.body(UtilsClass.addNewEmployee("amruta@gmail.com", "Amruta", "Panajbi", "Image"));
		resp = httpRequest.put(actualId);
		Assert.assertEquals(resp.getStatusCode(), 200);
		System.out.println(resp.getBody().asString());
	}

	@Test(priority = 10)
	public void validateBody() {
		Assert.assertEquals(resp.getBody().asString().contains("Amruta"), true);
	}

	@Test(priority = 11)
	public void validateContentTypeHeaderUsingPut() {
		Assert.assertEquals(resp.getHeader("Content-Type").contains("json"), true);
	}

	@Test(priority = 12)
	public void validateUpdateEntity() {

		resp = httpRequest.get(actualId);
		System.out.println(resp.getStatusCode());
		System.out.println(resp.getStatusLine());
		System.out.println(resp.getBody().asString());

		System.out.println("----------------------------");

		Headers allHeader = resp.getHeaders();

		for (Header abc : allHeader) {
			System.out.println(abc.getName() + ":::" + abc.getValue());
		}

	}

}