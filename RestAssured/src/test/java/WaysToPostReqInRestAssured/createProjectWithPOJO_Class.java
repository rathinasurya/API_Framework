package WaysToPostReqInRestAssured;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import PojoClass.PojoClass;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class createProjectWithPOJO_Class {
	@Test
	public void createProject() throws JsonGenerationException, JsonMappingException, IOException
	{
		PojoClass p=new PojoClass("surya", "Hospital_System", "pass", 12);
		baseURI="http://rmgtestingserver";
		port=8084;
		given().body(p).contentType(ContentType.JSON)
		.when().post("/addProject")
		.then().assertThat().time(Matchers.lessThan(5000L), TimeUnit.MILLISECONDS).log().all();
	}

}
