package Practice;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import GenericUtility.BaseClass;
import GenericUtility.EndPointLibrary;
import GenericUtility.ExcelUtility;
import GenericUtility.JavaLibrary;
import GenericUtility.RestAssuredLibrary;
import ObjectRepo.HomePage;
import ObjectRepo.ProjectsPage;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class CreateProjectInGUI_ValidateInDB_DeleteInAPI extends BaseClass {
	@Test
	public void createProjectUsingFramework() throws Throwable {
		// create Project in GUI
		HomePage hp = new HomePage(driver);
		ProjectsPage pp = new ProjectsPage(driver);
		ExcelUtility eu = new ExcelUtility();
		JavaLibrary jLib = new JavaLibrary();
		RestAssuredLibrary rLib = new RestAssuredLibrary();
		hp.clickOnProjBtn();
		String projectName = eu.getDataFromExcel("projects", 1, 0)+jLib.randomNumber();
		String createdBy = eu.getDataFromExcel("projects", 1, 1);
		String status = eu.getDataFromExcel("projects", 1, 2);
		pp.createNewProject(projectName, createdBy, status);
		Reporter.log("Project sucessfully created", true);

		// Validate project in DB
		String expData = driver.findElement(By.xpath("//td[.='"+projectName+"']/../td")).getText();
		System.out.println(expData);
		String query = "select * from project;";
		String actData = dLib.readDataFromDBAndValidate(query, 1, expData);
		Assert.assertEquals(expData, actData);
		Reporter.log("Project sucessfully validated");
		
		//Delete using API
		Response res=given().spec(req)
		.when().delete(EndPointLibrary.deleteProject+expData);
		//.then().spec(resp).statusCode(204).log().all();
		
	}
}
