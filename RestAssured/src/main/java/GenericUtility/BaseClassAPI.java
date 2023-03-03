package GenericUtility;

import java.sql.SQLException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static io.restassured.RestAssured.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class BaseClassAPI {
	public RequestSpecification req;
	public ResponseSpecification resp;
	DatabaseLibrary dLib=new DatabaseLibrary();
	JavaLibrary jLib=new JavaLibrary();
@BeforeSuite
public void bsConfig() throws SQLException
{
	dLib.connectToDB();
	req=new RequestSpecBuilder().setBaseUri("http://rmgtestingserver:8084").setContentType(ContentType.JSON).build();
}

@AfterSuite
public void asConfig() throws SQLException
{
	dLib.closeDB();
	resp=new ResponseSpecBuilder().expectContentType("application/json").build();
}

}
