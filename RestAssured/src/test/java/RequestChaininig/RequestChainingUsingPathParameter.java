package RequestChaininig;

import org.testng.annotations.Test;

import PojoClass.PojoClass;
import PojoClass.RandomNumber;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public class RequestChainingUsingPathParameter {
	@Test
	public void requestChaining()
	{
		RandomNumber ran=new RandomNumber();
		PojoClass p=new PojoClass("surya", "TYSS_HMS"+ran.randomKey(), "completed", 12);
		baseURI="http://rmgtestingserver";
		port=8084;
		Response resp = given().body(p).contentType(ContentType.JSON)
		.when().post("/addProject");
		String proId = resp.jsonPath().get("projectId");
		System.out.println(proId);
		resp.then().log().all();
		
		given().pathParam("pid",proId)
		.when().get("/projects/{pid}")
		.then().assertThat().statusCode(200).contentType(ContentType.JSON).log().all();
		
	}

}
