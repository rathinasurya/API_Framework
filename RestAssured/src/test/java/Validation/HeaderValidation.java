package Validation;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class HeaderValidation {
@Test
public void headerValidation()
{
	baseURI="http://rmgtestingserver";
	port=8084;
	
	String expContentType = "application/json";
	String expVary = "Access-Control-Request-Headers";
	String expPragma = "no-cache";
	String expConnection = "keep-alive";
	Response resp=when().get("/projects");
	String actualContentType = resp.getContentType();
	String actualVary = resp.getHeader("vary");
	String actualPragma = resp.getHeader("pragma");
	String actualConnection = resp.getHeader("Connection");
	resp.then().log().all();
	Assert.assertEquals(actualContentType, expContentType);
	Assert.assertEquals(actualVary, expVary);
	Assert.assertEquals(actualPragma, expPragma);	
	Assert.assertEquals(actualConnection, expConnection);	
	
			
}
}
