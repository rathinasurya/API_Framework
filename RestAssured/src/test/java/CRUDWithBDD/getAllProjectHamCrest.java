package CRUDWithBDD;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class getAllProjectHamCrest {
@Test
public void getprojects()
{
	baseURI="http://rmgtestingserver";
	port=8084;
	when().get("/projects")
	.then().assertThat().time(Matchers.lessThan(800l), TimeUnit.MILLISECONDS).log().all();

}
}
