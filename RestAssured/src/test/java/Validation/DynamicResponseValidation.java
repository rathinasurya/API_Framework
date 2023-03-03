package Validation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.List;

public class DynamicResponseValidation {
@Test
public void dynamicResponse()
{
	String expData="TY_PROJ_9919";
	baseURI="http://rmgtestingserver";
	port=8084;
	
	Response resp=when().get("/projects");
	
	boolean flag=false;
	List<String> pIDs = resp.jsonPath().get("projectId");
	for(String projectID:pIDs)
	{
		if(projectID.equalsIgnoreCase(expData))
		{
			flag=true;
		}
	}
	Assert.assertTrue(flag);
	resp.then().statusCode(200).log().all();
	System.out.println("Data Verified");
}
}
