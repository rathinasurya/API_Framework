package Authentication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class DigestiveAuth {
@Test
public void digestiveAuth()
{
	baseURI="http://rmgtestingserver";
	port=8084;
	given().auth().digest("rmgyantra", "rmgy@9999")
	.when().get("/login")
	.then().assertThat().statusCode(202).log().all();
}
}
