package Tutorial12;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Utils.UtilsClass;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class postDemo3 {
	Response resp;

	@BeforeClass
	public void setUp() {
		RestAssured.baseURI = "http://localhost:3000/posts";

		String requestPayload = UtilsClass.addNewEmployee("Ganesh", "Patil", "Pune", "Test Engineer");

		resp = given().contentType(ContentType.JSON).and().body(requestPayload).when().post().then()
				.extract().response();
	}

	@Test(priority = 1)
	public void validateStatusCode() {
		Assert.assertEquals(resp.statusCode(), 201);
	}

	@Test(priority = 2)
	public void validateStatusLine() {
		Assert.assertEquals(resp.statusLine().contains("Created"), true);
	}

	@Test(priority = 3)
	public void validateResponseFirstNamePayload() {
		Assert.assertEquals(resp.jsonPath().getString("FirstName"), "Ganesh");
	}

	@Test(priority = 4)
	public void validateContentTypeHeader() {
		System.out.println(resp.contentType());

		Assert.assertEquals(resp.contentType(), "application/json; charset=utf-8");
	}

}
