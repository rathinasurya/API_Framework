package Practice;

import static io.restassured.RestAssured.given;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Test;

import GenericUtility.BaseClass;
import GenericUtility.EndPointLibrary;
import GenericUtility.ExcelUtility;
import GenericUtility.JavaLibrary;
import GenericUtility.RestAssuredLibrary;
import ObjectRepo.HomePage;
import ObjectRepo.ProjectsPage;
import PojoClass.PojoClass;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import junit.framework.Assert;

public class CreateProjectInGUI_UpdateInAPI_ValidateInDB extends BaseClass{
	@Test
	public void CreateProjectUsingFramework() throws Throwable
	{
		//create Project in GUI
		HomePage hp=new HomePage(driver);
		ProjectsPage pp=new ProjectsPage(driver);
		ExcelUtility eu=new ExcelUtility();
		JavaLibrary jLib=new JavaLibrary();
		RestAssuredLibrary rLib=new RestAssuredLibrary();
		hp.clickOnProjBtn();
		String projectName = eu.getDataFromExcel("projects", 1, 0)+jLib.randomNumber();
		String createdBy = eu.getDataFromExcel("projects", 1, 1);
		String status = eu.getDataFromExcel("projects", 1, 2);
		pp.createNewProject(projectName, createdBy, status);
		System.out.println("Project created sucessfully");
		
		//Update Project Using RestAssured
		String projID=driver.findElement(By.xpath("//td[.='"+projectName+"']/../td")).getText();
		PojoClass p=new PojoClass("rathinasurya", "HMS_New_Modified"+jLib.randomNumber(), "pass", 8);
		Response res=given().spec(req).body(p)
		.when().put(EndPointLibrary.updateProject+projID);
		//res.then().spec(resp).statusCode(200).log().all();
		
		//Validate project in DB
		String expData = rLib.getJsonData(res, "projectId");
		String query="select * from project;";
		String actData = dLib.readDataFromDBAndValidate(query, 1, expData);
		Assert.assertEquals(expData, actData);
		Reporter.log("Project validated", true);
		
}
}
