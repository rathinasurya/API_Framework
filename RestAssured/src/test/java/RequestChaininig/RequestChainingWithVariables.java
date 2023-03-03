package RequestChaininig;

import org.testng.annotations.Test;

import PojoClass.PojoClass;
import PojoClass.RandomNumber;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class RequestChainingWithVariables {
@Test
public void requestChaining()
{
	RandomNumber ran=new RandomNumber();
	PojoClass p=new PojoClass("rathinasurya", "Hospital"+ran.randomKey(), "pass", 14);
	baseURI="http://rmgtestingserver";
	port=8084;
	Response resp=given().body(p).contentType(ContentType.JSON)
	.when().post("/addProject");
	String proId=resp.jsonPath().get("projectId");
	System.out.println(proId);
	resp.then().assertThat().statusCode(201).contentType(ContentType.JSON).log().all();
	
	given().when().get("/projects/"+proId)
	.then().statusCode(200).log().all();
	
}
}
