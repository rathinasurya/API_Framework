package WaysToPostReqInRestAssured;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class createProjectUsingJSONFile {
@Test
public void createproject() throws FileNotFoundException
{
			//step1: PreCondition
			given().body(new File("./sample.json")).contentType(ContentType.JSON)
			
			//step2: Action
			.when().post("http://rmgtestingserver:8084/addProject")
			
			//step3: Validation
			.then().assertThat().time(Matchers.lessThan(1000l),TimeUnit.MILLISECONDS).statusCode(201).contentType(ContentType.JSON).log().all();
}
}
