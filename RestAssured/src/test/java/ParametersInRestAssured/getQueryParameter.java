package ParametersInRestAssured;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class getQueryParameter {
	@Test 
	public void getProject()
	{
		given().queryParam("page", 2)
		.when().get("https://reqres.in/api/users")
		.then().statusCode(200).contentType(ContentType.JSON).log().all();
	}

}
