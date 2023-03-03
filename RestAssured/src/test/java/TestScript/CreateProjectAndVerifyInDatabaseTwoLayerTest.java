package TestScript;

import org.testng.Assert;
import org.testng.annotations.Test;

import GenericUtility.BaseClass;
import GenericUtility.EndPointLibrary;
import GenericUtility.JavaLibrary;
import PojoClass.PojoClass;
import static io.restassured.RestAssured.*;

import java.sql.SQLException;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateProjectAndVerifyInDatabaseTwoLayerTest extends BaseClass {
@Test
public void createProject() throws SQLException
{
	JavaLibrary jLib=new JavaLibrary();
	PojoClass p=new PojoClass("surya", "APITestProject"+jLib.randomNumber(), "pass", 15);
	Response resp=given().body(p).contentType(ContentType.JSON)
	.when().post(EndPointLibrary.createProject);
	String expData=rLib.getJsonData(resp, "projectId");
	String query="select * from project;";
	String actData=dLib.readDataFromDBAndValidate(query, 1, expData);
	Assert.assertEquals(expData, actData);
	System.out.println("Test case verifed and pass");
	resp.then().log().all();
			
}
}
