package Practice;
//Done
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import GenericUtility.BaseClass;
import GenericUtility.EndPointLibrary;
import GenericUtility.JavaLibrary;
import GenericUtility.RestAssuredLibrary;
import ObjectRepo.HomePage;
import PojoClass.PojoClass;

import static io.restassured.RestAssured.*;

import java.sql.SQLException;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateprojectInAPI_ValidateInGUI_DeleteInDB extends BaseClass {
	JavaLibrary jLib=new JavaLibrary();

	RestAssuredLibrary rLib=new RestAssuredLibrary();
	@Test
	public void CreateProjectUsingFramework() throws InterruptedException, SQLException
	{
	//Create project
	PojoClass p=new PojoClass("surya", "Hospital_Management"+jLib.randomNumber(), "pass", 3);
	Response res=given().spec(req).body(p)
	.when().post(EndPointLibrary.createProject);
	res.then().log().all();
	System.out.println("Project Created Sucessfully");
	
	//validation
	HomePage hp=new HomePage(driver);
	hp.clickOnProjBtn();
	String expData=rLib.getJsonData(res, "projectId");
	String ActualData=driver.findElement(By.xpath("//tr/td[.='"+expData+"']")).getText();
	Assert.assertEquals(expData, ActualData);
	Reporter.log("Project verified", true);
	
	//deleteProject
	String query="Delete from project where project_Id='"+expData+"';";
	dLib.deleteDataFromDB(query);
	
	}
	
	

}
