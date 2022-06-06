package Tutorial;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.http.Header;

public class putDemo {

	public static void main(String[] args) {

		JSONObject json = new JSONObject();
		json.put("FirstName", "abc");
		json.put("LastName", "xyz");
		json.put("Address", "Pune");
		json.put("Job", "Testing");

		RestAssured.baseURI = "http://localhost:3000/posts";

		Response resp = given().contentType(ContentType.JSON).and().body(json.toString()).when().put("/2").then()
				.extract().response();

		System.out.println(resp.jsonPath().getString("FirstName"));

		System.out.println(resp.statusCode());
		System.out.println(resp.statusLine());

		String abc = resp.getBody().asString();
		System.out.println(abc);

		Headers all = resp.headers();

		for (Header a : all) {
			System.out.println(a.getName() + "::" + a.getValue());
		}

	}

}
