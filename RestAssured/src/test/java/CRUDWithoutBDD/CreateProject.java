package CRUDWithoutBDD;

import org.apache.commons.lang3.text.translate.JavaUnicodeEscaper;
import org.json.simple.JSONObject;
import org.junit.experimental.theories.suppliers.TestedOn;
import org.testng.annotations.Test;

import PojoClass.RandomNumber;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateProject {
	@Test
	public void createproject()
	{
	RandomNumber ran=new RandomNumber();
	JSONObject ob=new JSONObject();
	ob.put("createdBy", "surya");
	ob.put("projectName", "TYSS" +ran.randomKey());
	ob.put("status", "pass");
	ob.put("teamSize", 4);
	
	RequestSpecification req = RestAssured.given();
	req.body(ob);
	req.contentType(ContentType.JSON);
	
	Response resp = req.post("http://rmgtestingserver:8084/addProject");
	
	System.out.println(resp.getContentType());
	System.out.println(resp.asPrettyString());
	System.out.println(resp.prettyPeek());
	System.out.println(resp.asString());
	
	//TY_PROJ_18774
	}
}
