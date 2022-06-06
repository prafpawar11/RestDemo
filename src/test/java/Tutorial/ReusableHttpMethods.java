package Tutorial;

import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ReusableHttpMethods {

	public static Response postDemo(String Requestbody) {

		return given().contentType(ContentType.JSON).and().body(Requestbody).when().post().then().extract().response();
	}

	public static Response getDemo(String id) {

		return given().contentType(ContentType.JSON).when().get(id).then().extract().response();
	}

	public static Response putDemo(String requestBody, String id) {

		return given().contentType(ContentType.JSON).and().body(requestBody).when().put(id).then().extract().response();
	}

	public static Response patchDemo(String requestBody, String id) {

		return given().contentType(ContentType.JSON).and().body(requestBody).when().patch(id).then().extract()
				.response();
	}

	public static Response deleteDemo(String id) {

		return given().contentType(ContentType.JSON).when().delete(id).then().extract().response();
	}

}
