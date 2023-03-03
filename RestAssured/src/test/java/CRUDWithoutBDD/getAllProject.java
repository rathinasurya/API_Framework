package CRUDWithoutBDD;

import static org.testng.Assert.assertEquals;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class getAllProject {
@Test
public void getProjects()
{
RequestSpecification req = RestAssured.given();
Response resp = req.get("http://rmgtestingserver:8084/projects");
resp.then().log().all();
int statusCode = resp.getStatusCode();
Assert.assertEquals(200, statusCode);

}
}
