package WaysToPostReqInRestAssured;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import PojoClass.RandomNumber;
import io.restassured.http.ContentType;

public class createProjectUsingJSON_Object {
	@Test
	public void createProject()
	{
		baseURI="http://rmgtestingserver";
		port=8084;
		RandomNumber ran=new RandomNumber();
		
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy", "surya");
		jobj.put("projectName", "Tyss_HMS"+ran.randomKey());
		jobj.put("status", "pass");
		jobj.put("teamSize", 12);
		
		//step1: PreCondition
		given().body(jobj).contentType(ContentType.JSON)
		
		//step2: Action
		.when().post("/addProject")
		
		//step3: Validation
		.then().assertThat().time(Matchers.lessThan(5000l),TimeUnit.MILLISECONDS).statusCode(201).contentType(ContentType.JSON).log().all();
	}
}
