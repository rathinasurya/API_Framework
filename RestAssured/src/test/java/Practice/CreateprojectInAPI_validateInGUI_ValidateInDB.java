package Practice;

import static io.restassured.RestAssured.given;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import GenericUtility.BaseClass;
import GenericUtility.DatabaseLibrary;
import GenericUtility.EndPointLibrary;
import GenericUtility.ExcelUtility;
import GenericUtility.JavaLibrary;
import ObjectRepo.HomePage;
import PojoClass.PojoClass;
import io.restassured.response.Response;

public class CreateprojectInAPI_validateInGUI_ValidateInDB extends BaseClass {
	@Test
	public void createProjectusingFramework() throws Throwable {
		// Create Project
		JavaLibrary jLib = new JavaLibrary();
		PojoClass p = new PojoClass("Surya", "API_project" + jLib.randomNumber(), "pass", 8);
		Response res = given().spec(req).body(p).when().post(EndPointLibrary.createProject);
		res.then().log().all();
		System.out.println("Project Created Sucessfully");

		// Validate In GUI
		HomePage hp = new HomePage(driver);
		hp.clickOnProjBtn();
		String expData = rLib.getJsonData(res, "projectId");
		String ActualData = driver.findElement(By.xpath("//tr/td[.='" + expData + "']")).getText();
		Assert.assertEquals(expData, ActualData);
		Reporter.log("Project verified", true);

		// Validate in DB
		String query = "select * from project;";
		String actData = dLib.readDataFromDBAndValidate(query, 1, expData);
		Assert.assertEquals(expData, actData);
		Reporter.log("Project validated", true);

	}
}
