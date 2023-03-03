package Practice;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import GenericUtility.BaseClass;
import GenericUtility.EndPointLibrary;
import GenericUtility.ExcelUtility;
import GenericUtility.JavaLibrary;
import ObjectRepo.HomePage;
import ObjectRepo.ProjectsPage;
import PojoClass.PojoClass;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
//Done
public class CreateProjectInGUI_UpdateInAPI_DeleteInDB extends BaseClass{
	@Test
	public void CreateProjectUsingFramework() throws Throwable
	{
		//create Project in GUI
		ProjectsPage pp=new ProjectsPage(driver);
		ExcelUtility eu=new ExcelUtility();
		JavaLibrary jLib=new JavaLibrary();
		HomePage hp=new HomePage(driver);
		hp.clickOnProjBtn();
		String projectName = eu.getDataFromExcel("projects", 1, 0)+jLib.randomNumber();
		String createdBy = eu.getDataFromExcel("projects", 1, 1);
		String status = eu.getDataFromExcel("projects", 1, 2);
		pp.createNewProject(projectName, createdBy, status);
		System.out.println("project created Sucessfully");
		
		//Update Project Using RestAssured
		String projID=driver.findElement(By.xpath("//td[.='"+projectName+"']/../td")).getText();
		System.out.println("Project ID: "+projID);
		PojoClass p=new PojoClass("surya", "HMS_Modified"+jLib.randomNumber(), "pass", 6);
		Response res=given().spec(req).body(p)
		.when().put(EndPointLibrary.updateProject+projID);
		res.then().spec(resp).log().all();
		
		//Delete project in DB
		String query="Delete from project where project_Id='"+projID+"';";
		dLib.deleteDataFromDB(query);
	}

}
