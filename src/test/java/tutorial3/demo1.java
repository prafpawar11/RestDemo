package tutorial3;

import org.apache.juneau.json.JsonSchemaSerializer;
import org.apache.juneau.json.JsonSerializer;

import com.fasterxml.jackson.databind.ObjectMapper;

public class demo1 {

	public static void main(String[] args) {

		demo o = new demo();
		o.setId(1);
		o.setName("abc");
		o.setAddress("Pune");
		o.setJob("Tester ");

		ObjectMapper mapperObj = new ObjectMapper();

		try {
			// get Employee object as a json string
			String jsonStr = mapperObj.writeValueAsString(o);
			System.out.println(jsonStr);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
