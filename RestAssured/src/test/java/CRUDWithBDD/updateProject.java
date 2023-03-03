package CRUDWithBDD;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class updateProject 
{
@Test
public void updateProjects()
{
	baseURI="http://rmgtestingserver";
	port=8084;
	
	JSONObject jobj=new JSONObject();
	jobj.put("createdBy", "surya");
	jobj.put("projectName", "Tyss_HMS_001");
	jobj.put("status", "completed");
	jobj.put("teamSize", 4);
	
	given().body(jobj).contentType(ContentType.JSON)
	.when().put("/projects/TY_PROJ_18935")
	.then().assertThat().statusCode(200).contentType(ContentType.JSON).log().all();

	
	
}
}
