package CRUDWithoutBDD;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetExactProject {
	@Test
	public void getProject()
	{
		RequestSpecification req = RestAssured.given();
		Response resp = req.get("http://rmgtestingserver:8084/projects/TY_PROJ_18884");
		resp.then().log().all();
		int statusCode = resp.getStatusCode();
		Assert.assertEquals(200, statusCode);

		
		
	}

}
