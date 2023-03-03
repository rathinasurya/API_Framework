package CRUDWithBDD;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class deleteProject {
	@Test
	public void deleteProjects()
	{
		baseURI="http://rmgtestingserver";
		port=8084;
		when().delete("/projects/TY_PROJ_9960")
		.then().assertThat().time(Matchers.lessThan(8000l), TimeUnit.MILLISECONDS).statusCode(204).contentType(ContentType.JSON).log().all();
	}

}
