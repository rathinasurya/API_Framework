package ParametersInRestAssured;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class CreateFormParameter {
	@Test
	public void CreateProject()
	{
		given().formParam("createdBy", "surya")
		.formParam("projectName", "Hospital_Management")
		.formParam("status", "pass")
		.formParam("teamSize", 5)
		.when().post("http://localhost:8080/addProject")
		.then().assertThat().statusCode(201).contentType(ContentType.JSON).log().all();
	}
	

}
