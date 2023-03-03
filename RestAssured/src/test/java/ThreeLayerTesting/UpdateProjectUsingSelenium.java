package ThreeLayerTesting;

import static io.restassured.RestAssured.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;

import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

import io.restassured.http.ContentType;

public class UpdateProjectUsingSelenium {
@Test
public void updateProject() throws SQLException
{
	//Create Project Using Selenium
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("http://rmgtestingserver:8084/");
	driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
	driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
	driver.findElement(By.xpath("//button[.='Sign in']")).click();
	driver.findElement(By.xpath("//a[.='Projects']")).click();
	driver.findElement(By.xpath("//div[@class='col-sm-6']/button/span[.='Create Project']")).click();
	driver.findElement(By.xpath("//input[@name='projectName']")).sendKeys("APIProject3456");
	driver.findElement(By.xpath("//input[@name='createdBy']")).sendKeys("surya");
	WebElement DD = driver.findElement(By.xpath("//label[.='Project Status ']/following-sibling::select[@name='status']"));
	Select s=new Select(DD);
	s.selectByValue("Completed");
	driver.findElement(By.xpath("//input[@value='Add Project']")).click();
	String proId=driver.findElement(By.xpath("//td[.='APIProject3456']/../td[1]")).getText();
	System.out.println(proId);
	
	//Update Project using RestAssured
	baseURI="http://rmgtestingserver:8084/";
	port=8084;
	JSONObject ob=new JSONObject();
	ob.put("createdBy", "rathinasurya");
	ob.put("projectName", "Updated_API_Project");
	ob.put("status", "completed");
	ob.put("teamSize", 8);
	given().body(ob).contentType(ContentType.JSON)
	.when().put("/projects/"+proId+"")
	.then().assertThat().statusCode(200).contentType(ContentType.JSON).log().all();
	
	//Validate updated project in DataBase
	String proName="Updated_API_Project";
	Connection con=null;
	try {
	Driver driver1=new Driver();
	DriverManager.registerDriver(driver1);
	con=DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects", "root@%", "root");
	Statement state=con.createStatement();
	String query="select * from project where project_Name='"+proName+"';";
	ResultSet result = state.executeQuery(query);
	while(result.next())
	{
		String data=result.getString(4);
	//	System.out.println(data);
		if(proName.equalsIgnoreCase(data))
		{
			System.out.println("Updated project verified");
		}
	}
	}
	catch (Exception e) {
		
	}
	finally {
		con.close();
	}
	
}
}



