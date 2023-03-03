package PetStore;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.io.File;

public class CreatePet {
@Test
public void createPet()
{
	given().body(new File("./pet.json")).contentType(ContentType.JSON)
	.when().post("https://petstore.swagger.io/v2/pet")
	.then().log().all();
}
}
