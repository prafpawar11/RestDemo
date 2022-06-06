package Tutorial;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Utils.UtilsClass;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class EndToEndFlowDemo {
	// Post---------> get--------> put---------> get----->
	// patch------>get----->delete--->get
	Response resp;
	String empid;

	@BeforeClass
	public void setUp() {
		RestAssured.baseURI = "http://localhost:3000/posts";
		String reqBody = UtilsClass.addNewEmployee("Harshada", "Patil", "Pune", "Sr Test Engineer");

		resp = ReusableHttpMethods.postDemo(reqBody);
	}

	@Test(priority = 1)
	public void validateStatusCode() {

		Assert.assertEquals(201, resp.statusCode());
	}

	@Test(priority = 2)
	public void validateStatusLine() {
		Assert.assertEquals(true, resp.statusLine().contains("Created"));
	}

	@Test(priority = 3)
	public void validateResponsePayLoadFirstName() {
		Assert.assertEquals("Harshada", resp.jsonPath().getString("FirstName"));
	}

	@Test(priority = 4)
	public void validateResponsePayLoadLastName() {
		Assert.assertEquals("Patil", resp.jsonPath().getString("LastName"));
	}

	@Test(priority = 5)
	public void validateResponsePayLoadAddressName() {
		Assert.assertEquals("Pune", resp.jsonPath().getString("Address"));
	}

	@Test(priority = 6)
	public void validateResponsePayLoadJobName() {
		Assert.assertEquals("Sr Test Engineer", resp.jsonPath().getString("Job"));
	}

	@Test(priority = 7)
	public void validateContentTypeHeader() {

		Assert.assertEquals(resp.contentType(), "application/json; charset=utf-8");
	}

	@Test(priority = 8)
	public void getIdFromResponsePayload() {
		empid = resp.jsonPath().getString("id");
	}

	@Test(priority = 9)
	public void validateStatusCodeusingget() {
		resp = ReusableHttpMethods.getDemo(empid);
		Assert.assertEquals(200, resp.statusCode());
	}

	@Test(priority = 10)
	public void validateStatusLineUsingGet() {
		Assert.assertEquals(true, resp.statusLine().contains("OK"));
	}

	@Test(priority = 11)
	public void validateResponsePayLoadFirstNameget() {
		Assert.assertEquals("Harshada", resp.jsonPath().getString("FirstName"));
	}

	@Test(priority = 12)
	public void validateResponsePayLoadLastNameget() {
		Assert.assertEquals("Patil", resp.jsonPath().getString("LastName"));
	}

	@Test(priority = 13)
	public void validateResponsePayLoadAddressNameget() {
		Assert.assertEquals("Pune", resp.jsonPath().getString("Address"));
	}

	@Test(priority = 14)
	public void validateResponsePayLoadJobNameget() {
		Assert.assertEquals("Sr Test Engineer", resp.jsonPath().getString("Job"));
	}

	@Test(priority = 15)
	public void validateContentTypeHeaderget() {
		Assert.assertEquals(resp.contentType(), "application/json; charset=utf-8");
	}

	@Test(priority = 16)
	public void updateEntityUsingPutRequest() {

		String reqBody = UtilsClass.addNewEmployee("Pankaj", "Pawase", "Mumbai", "sr Automation Tester");
		resp = ReusableHttpMethods.putDemo(reqBody, empid);
	}

	@Test(priority = 17)
	public void validateStatusCodeusingPut() {
		Assert.assertEquals(200, resp.statusCode());
	}

	@Test(priority = 18)
	public void validateStatusLineUsingPut() {
		Assert.assertEquals(true, resp.statusLine().contains("OK"));
	}

	@Test(priority = 19)
	public void validateResponsePayLoadFirstNamePut() {
		Assert.assertEquals("Pankaj", resp.jsonPath().getString("FirstName"));
	}

	@Test(priority = 20)
	public void validateResponsePayLoadLastNamePut() {
		Assert.assertEquals("Pawase", resp.jsonPath().getString("LastName"));
	}

	@Test(priority = 21)
	public void validateResponsePayLoadAddressNamePut() {
		Assert.assertEquals("Mumbai", resp.jsonPath().getString("Address"));
	}

	@Test(priority = 22)
	public void validateResponsePayLoadJobNamePut() {
		Assert.assertEquals("sr Automation Tester", resp.jsonPath().getString("Job"));
	}

	@Test(priority = 23)
	public void validateContentTypeHeaderPut() {
		Assert.assertEquals(resp.contentType(), "application/json; charset=utf-8");
	}

	@Test(priority = 24)
	public void validateStatusCodeusingget1() {
		resp = ReusableHttpMethods.getDemo(empid);
		Assert.assertEquals(200, resp.statusCode());
	}

	@Test(priority = 25)
	public void validateStatusLineUsingGet1() {
		Assert.assertEquals(true, resp.statusLine().contains("OK"));
	}

	@Test(priority = 26)
	public void validateResponsePayLoadFirstNameget1() {
		Assert.assertEquals("Pankaj", resp.jsonPath().getString("FirstName"));
	}

	@Test(priority = 27)
	public void validateResponsePayLoadLastNameget1() {
		Assert.assertEquals("Pawase", resp.jsonPath().getString("LastName"));
	}

	@Test(priority = 28)
	public void validateResponsePayLoadAddressNameget1() {
		Assert.assertEquals("Mumbai", resp.jsonPath().getString("Address"));
	}

	@Test(priority = 29)
	public void validateResponsePayLoadJobNameget1() {
		Assert.assertEquals("sr Automation Tester", resp.jsonPath().getString("Job"));
	}

	@Test(priority = 30)
	public void validateContentTypeHeaderget1() {
		Assert.assertEquals(resp.contentType(), "application/json; charset=utf-8");
	}

	@Test(priority = 31)
	public void updateSpecificEntity() {

		String reqBody = UtilsClass.updateSpecificEntity("FirstName", "Sachin");
		resp = ReusableHttpMethods.patchDemo(reqBody, empid);
	}

	@Test(priority = 32)
	public void validateStatusCodeusingPatch() {
		Assert.assertEquals(200, resp.statusCode());
	}

	@Test(priority = 33)
	public void validateStatusLineUsingpatch() {
		Assert.assertEquals(true, resp.statusLine().contains("OK"));
	}

	@Test(priority = 34)
	public void validateResponsePayLoadFirstNamePatch() {
		Assert.assertEquals("Sachin", resp.jsonPath().getString("FirstName"));
	}

	@Test(priority = 35)
	public void validateResponsePayLoadLastNamePatch() {
		Assert.assertEquals("Pawase", resp.jsonPath().getString("LastName"));
	}

	@Test(priority = 36)
	public void validateResponsePayLoadAddressNamePatch() {
		Assert.assertEquals("Mumbai", resp.jsonPath().getString("Address"));
	}

	@Test(priority = 37)
	public void validateResponsePayLoadJobNamePatch() {
		Assert.assertEquals("sr Automation Tester", resp.jsonPath().getString("Job"));
	}

	@Test(priority = 38)
	public void deleteEntityFromServer() {
		resp = ReusableHttpMethods.deleteDemo(empid);
	}

	@Test(priority = 39)
	public void validateResponseForDeleteReq() {
		Assert.assertEquals(200, resp.statusCode());
	}

	@Test(priority = 40)
	public void validateStatusLineUsingDelete() {
		Assert.assertEquals(true, resp.statusLine().contains("OK"));
	}

	@Test(priority = 41)
	public void validateContentTypeDelet() {
		Assert.assertEquals(resp.contentType(), "application/json; charset=utf-8");
	}

	@Test(priority = 42)
	public void verifyEntityIsdeleteOrNotUsingStatusCode() {

		resp = ReusableHttpMethods.getDemo(empid);
		Assert.assertEquals(resp.getStatusCode(), 404);
	}

	@Test(priority = 43)
	public void verifyEntityIsdeleteOrNotUsingStatusLine() {
		Assert.assertEquals(true, resp.statusLine().contains("Not Found"));
	}

}
