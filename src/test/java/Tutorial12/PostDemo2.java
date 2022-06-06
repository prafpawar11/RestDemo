package Tutorial12;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class PostDemo2 {

	public static void main(String[] args) {

		RestAssured.baseURI = "http://localhost:3000/posts";

		JSONObject json = new JSONObject();
		json.put("FirstName", "Avinash");
		json.put("LastName", "Patil");
		json.put("Address", "Pune");
		json.put("Job", "Sr Test Engineer");

		String requestPayload = json.toString();

		Response resp = given().header("Content-Type", "application/json").and().body(requestPayload).when().post()
				.then().extract().response();

		System.out.println(resp.jsonPath().getString("FirstName"));

		System.out.println(resp.getStatusCode());
		System.out.println(resp.statusCode());

		System.out.println(resp.getStatusLine());
		System.out.println(resp.statusLine());

		System.out.println(resp.getBody().asString());

		Headers all = resp.headers();

		for (Header abc : all) {
			System.out.println(abc.getName() + ":::" + abc.getValue());
		}

	}

}
