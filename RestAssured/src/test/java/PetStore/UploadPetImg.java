package PetStore;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.io.File;

public class UploadPetImg {
@Test
public void uploadImg()
{
	JSONObject ob=new JSONObject();
	ob.put("code", "007");
	ob.put("type", "Dog");
	ob.put("message", "Dow Dow");
	
	baseURI="https://petstore.swagger.io/v2/";
	File f=new File("./pet.jpg");
	given().body(ob).contentType(ContentType.JSON)
	.pathParam("petId", "9223372036854739181")
	.when().post("/pet/{petId}/‪f")
	.then().log().all();
}
}
