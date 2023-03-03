package TestScript;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import GenericUtility.ExcelUtility;
import GenericUtility.FileUtility;
import GenericUtility.JavaLibrary;
import GenericUtility.WebdriverUtility;
import ObjectRepo.LoginPage;
import ObjectRepo.ProjectsPage;
import ObjectRepo.HomePage;

public class CreateProjectTest {
@Test
public void createProject() throws Throwable
{
	WebDriver driver=new ChromeDriver();
	WebdriverUtility wdu=new WebdriverUtility();
	wdu.waitForPageLoad(driver);
	HomePage hp=new HomePage(driver);
	ProjectsPage pp=new ProjectsPage(driver);
	FileUtility fu=new FileUtility();
	ExcelUtility eu=new ExcelUtility();
	LoginPage lp=new LoginPage(driver);
	JavaLibrary jLib=new JavaLibrary();
	driver.get("http://rmgtestingserver:8084");
	lp.getLoginPage(fu.getProperty("username"), fu.getProperty("password"));
	hp.clickOnProjBtn();
	pp.createNewProject(ProjectName, createdBy, status);
	driver.close();
	
	
	
	
	
	
}
}
