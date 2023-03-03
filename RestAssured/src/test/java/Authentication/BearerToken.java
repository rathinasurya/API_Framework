package Authentication;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class BearerToken {
@Test
public void bearerToken()
{
	baseURI="https://api.github.com";
	JSONObject ob=new JSONObject();
	ob.put("name", "API_001  ");
	given().auth().oauth2("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")
	.body(ob)
	.contentType(ContentType.JSON)
	.when().post("/user/repos")
	.then().assertThat().statusCode(201).log().all();
	
	
}
}
