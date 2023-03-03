package CRUDWithBDD;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class getExactProject {
	@Test
	public void getExactProjects()
	{
		baseURI="http://rmgtestingserver";
		port=8084;
		when().get("/projects/TY_PROJ_19056")
		.then().assertThat().time(Matchers.lessThan(1000l), TimeUnit.MILLISECONDS).statusCode(200).contentType(ContentType.JSON).log().all();
	}
	

}
