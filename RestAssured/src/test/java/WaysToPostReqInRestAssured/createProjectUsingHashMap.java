package WaysToPostReqInRestAssured;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import PojoClass.RandomNumber;
import io.restassured.http.ContentType;

public class createProjectUsingHashMap {
	@Test
	public void createProject()
	{
		baseURI="http://rmgtestingserver";
		port=8084;
		RandomNumber ran=new RandomNumber();
		
		HashMap<String, String> map=new HashMap<String, String>();
		
		map.put("createdBy", "surya");
		map.put("projectName", "Tyss_HMS"+ran.randomKey());
		map.put("status", "pass");
		map.put("teamSize", "12");
		
		//step1: PreCondition
		given().body(map).contentType(ContentType.JSON)
		
		//step2: Action
		.when().post("/addProject")
		
		//step3: Validation
		.then().assertThat().time(Matchers.lessThan(1000l),TimeUnit.MILLISECONDS).statusCode(201).contentType(ContentType.JSON).log().all();
	}


}
