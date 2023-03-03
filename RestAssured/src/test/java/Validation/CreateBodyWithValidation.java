package Validation;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import PojoClass.RandomNumber;

import static io.restassured.RestAssured.*;

import java.util.Random;

import io.restassured.http.ContentType;
import io.restassured.http.Cookie;
import io.restassured.http.Cookies;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class CreateBodyWithValidation {
@Test
public void postBody()
{
	RandomNumber ran=new RandomNumber();
	JSONObject ob=new JSONObject();
	ob.put("createdBy", "surya");
	ob.put("projectName", "TYSS_HMS" +ran.randomKey());
	ob.put("status", "pass");
	ob.put("teamSize", 4);
	baseURI="http://rmgtestingserver";
	port=8084;
	
	Response resp =given()
	.body(ob)
	.contentType(ContentType.JSON)
	.when().post("/addProject");
	
	ResponseBody body = resp.body();
	//System.out.println(body);
	ResponseBody getBody = resp.getBody();
	//System.out.println(getBody);
	String prettyString = resp.asPrettyString();
	//System.out.println(prettyString);
	String asString = resp.asString();
	//System.out.println(asString);
	String contentType = resp.contentType();
	//System.out.println(contentType);
	String getContentType = resp.getContentType();
	//System.out.println(getContentType);
	Cookies detailedCookies = resp.getDetailedCookies();
	//System.out.println(detailedCookies);
	String getStatusLine = resp.getStatusLine();
	//System.out.println(getStatusLine);
	Response prettyPeek = resp.prettyPeek();
	//System.out.println(prettyPeek);
	String prettyPrint = resp.prettyPrint();
	//System.out.println(prettyPrint);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
			
}
}
