package Authentication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class PreEmptiveAuth {
@Test
public void preemptive()
{
	baseURI="http://rmgtestingserver";
	port=8084;
	given().auth().preemptive().basic("rmgyantra", "rmgy@9999")
	.when().get("/login")
	.then().assertThat().statusCode(202).log().all();
}
}
