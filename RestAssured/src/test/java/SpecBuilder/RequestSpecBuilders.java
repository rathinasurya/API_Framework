package SpecBuilder;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import GenericUtility.JavaLibrary;
import static io.restassured.RestAssured.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;



public class RequestSpecBuilders {
@Test
public void createproject()
{
RequestSpecification req=new RequestSpecBuilder().setBaseUri("http://rmgtestingserver:8084").setContentType(ContentType.JSON).build();
ResponseSpecification resp = new ResponseSpecBuilder().expectStatusCode(201).expectContentType(ContentType.JSON).build();

JavaLibrary jLib=new JavaLibrary();
JSONObject jobj=new JSONObject();
jobj.put("createdBy", "suryas");
jobj.put("projectName", "Tyss_HMS"+jLib.randomNumber());
jobj.put("status", "pass");
jobj.put("teamSize", 4);

given().spec(req).body(jobj)
.when().post("/addProject")
.then().spec(resp).log().all();
}
}
			
