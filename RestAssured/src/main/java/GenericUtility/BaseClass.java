package GenericUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import ObjectRepo.HomePage;
import ObjectRepo.LoginPage;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

public class BaseClass {
public DatabaseLibrary dLib=new DatabaseLibrary();
public JavaLibrary jLib=new JavaLibrary();
public RestAssuredLibrary rLib=new RestAssuredLibrary();
public RequestSpecification req;
public ResponseSpecification resp;
public WebDriver driver;

public WebdriverUtility wLib=new WebdriverUtility();
public FileUtility fu=new FileUtility();
@BeforeSuite
public void bsConfig() throws SQLException
{
	dLib.connectToDB();
	req=new RequestSpecBuilder().setBaseUri("http://rmgtestingserver:8084").setContentType(ContentType.JSON).build();
	
}
@BeforeClass
public void openBrowser() throws IOException
{
	
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get(fu.getProperty("url"));
	System.out.println("---Browser Launched Sucessfully---");
}
@BeforeMethod
public void bmConfig() throws FileNotFoundException, IOException
{
	LoginPage lp=new LoginPage(driver);
	lp.getLoginPage(fu.getProperty("username"),fu.getProperty("password"));
	wLib.waitForPageLoad(driver);
}

@AfterMethod
public void amConfig()
{
	wLib.waitForPageLoad(driver);
	HomePage hp=new HomePage(driver);
	hp.clickOnLogoutBtn();

			
}

@AfterClass
public void closeBrowser()
{
	wLib.waitForPageLoad(driver);
	driver.close();
	System.out.println("---Browser Closed---");
}

@AfterSuite
public void asConfig() throws SQLException
{
	dLib.closeDB();
	resp=new ResponseSpecBuilder().expectContentType(ContentType.JSON).build();
	
}
}
