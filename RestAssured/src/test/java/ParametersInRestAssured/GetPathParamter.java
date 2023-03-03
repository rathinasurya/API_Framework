package ParametersInRestAssured;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class GetPathParamter {
@Test
public void getProject()
{
	given().pathParam("pid", "TY_PROJ_19245")
	.when().get("http://rmgtestingserver:8084/projects/{pid}")
	.then().assertThat().statusCode(200).contentType(ContentType.JSON);
}
}
