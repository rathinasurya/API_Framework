package Validation;

import static io.restassured.RestAssured.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.response.Response;

public class StaticResponseValidation {
	@Test
	public void staticResp()
	{
	String expData="TY_PROJ_11289";
	baseURI="http://rmgtestingserver";
	port=8084;
	
	Response resp = when().get("/projects");
	String actData=resp.jsonPath().get("[1].projectId");
	Assert.assertEquals(actData, expData);
	System.out.println("Data is verified");
	resp.then().statusCode(200);
	
}
}