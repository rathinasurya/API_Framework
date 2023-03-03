package CRUDWithoutBDD;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class deleteProject {
@Test
public void deleteProject()
{
	RequestSpecification req = RestAssured.given();
	Response resp = req.delete("http://rmgtestingserver:8084/projects/TY_PROJ_18774");
	resp.then().log().all();
	int statusCode = resp.getStatusCode();
	Assert.assertEquals(204, statusCode);
}
}
