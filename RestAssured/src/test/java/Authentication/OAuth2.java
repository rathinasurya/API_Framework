package Authentication;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;

public class OAuth2 {
	@Test
	public void oAuth2()
	{
		 Response resp=given().formParam("client_id", "HospitalManagement" )
		.formParam("client_secret", "d760f541815bf1c3a77c9e7af36c9200")
		.formParam("grant_type","client_credentials" )
		.formParam("redirect_uri ","http://hospitalmanagement.com" )
		.formParam("code ","authorization_code" )
		
		.when().post("http://coop.apps.symfonycasts.com/token");
		
		//.then().log().all();
		String token = resp.jsonPath().get("access_token");
		System.out.println(token);
		
		given().auth().oauth2(token)
		.pathParam("USER_ID", 4346)
		.when().post("http://coop.apps.symfonycasts.com/api/{USER_ID}/eggs-collect")
	
		
		.then().log().all();
		
	}

}
