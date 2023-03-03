package PetStore;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class GetProject {
@Test
public void getProject()
{
	given().pathParam("petId", "9223372036854739181")
	.when().get("https://petstore.swagger.io/v2/pet/{petId}")
	.then().log().all();
	
}
}
