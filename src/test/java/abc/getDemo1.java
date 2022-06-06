package abc;

import org.apache.juneau.json.JsonSerializer;
import org.testng.annotations.Test;

import com.BaseLayer.BaseClass;
import com.Utils.UtilsClass;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class getDemo1 extends BaseClass{

//	RequestSpecification httpRequest;
	Response resp;

	@Test
	public void m1() throws Exception {
		// TODO Auto-generated method stub
		RestAssured.baseURI = "http://localhost:3000/posts";

		// serialization:
		// pojo to json:
		JsonSerializer jsonSerializer = JsonSerializer.DEFAULT_READABLE;
		String sellerNames[] = { "Neon Enterprise", "ABC Software", "XYZ IT solutions" };
		Product product = new Product("MAcbookPro", 1000, "White", sellerNames);
		String json = jsonSerializer.serialize(product);
		System.out.println(json);

		BaseClass.initialization();
		httpRequest.header("Content-Type", "application/json");
		httpRequest.body(json);
		resp = httpRequest.post();

		System.out.println(resp.getStatusCode());
		System.out.println(resp.getStatusLine());
	}

}
