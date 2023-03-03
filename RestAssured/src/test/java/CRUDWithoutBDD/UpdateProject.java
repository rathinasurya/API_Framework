package CRUDWithoutBDD;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateProject {
@Test
public void updateProject()
{
	JSONObject ob=new JSONObject();
	ob.put("createdBy", "rathinasurya");
	ob.put("projectName", "TYSS_Hospital");
	ob.put("status", "pass");
	ob.put("teamSize", 3);
	
	RequestSpecification req = RestAssured.given();
	req.body(ob);
	req.contentType(ContentType.JSON);
	Response resp = req.put("http://rmgtestingserver:8084/projects/TY_PROJ_18884");
	int statusCode = resp.getStatusCode();
	Assert.assertEquals(200, statusCode);

	
	System.out.println(resp.contentType());
	System.out.println(resp.asPrettyString());
	System.out.println(resp.asString());
	System.out.println(resp.prettyPeek());
	
	
}
}
