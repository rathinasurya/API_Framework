package DataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PojoClass.PojoClass;
import PojoClass.RandomNumber;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateProjectWithDataProvider {
	@Test(dataProvider = "getData")
	public void createProject(String createdBy, String projectName, String status, int teamSize) {
		RandomNumber ran = new RandomNumber();
		PojoClass p = new PojoClass(createdBy, projectName + ran.randomKey(), status, teamSize);
		baseURI = "http://rmgtestingserver";
		port = 8084;
		given().body(p).contentType(ContentType.JSON).when().post("/addProject").then().statusCode(201).log().all();
	}
	@DataProvider(name = "getData")
	public Object[][] data() {
		Object[][] data = new Object[3][4];
		data[0][0] = "surya";
		data[0][1] = "HMS_001";
		data[0][2] = "pass";
		data[0][3] = 12;

		data[1][0] = "gopi";
		data[1][1] = "Sales";
		data[1][2] = "completed";
		data[1][3] = 4;

		data[2][0] = "vinay";
		data[2][1] = "OnlineBanking";
		data[2][2] = "onGoing";
		data[2][3] = 8;

		return data;

	}

}
