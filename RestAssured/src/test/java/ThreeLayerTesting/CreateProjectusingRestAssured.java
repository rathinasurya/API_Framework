package ThreeLayerTesting;

import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

import PojoClass.RandomNumber;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.util.List;

public class CreateProjectusingRestAssured {
	@Test
	public void addProject() throws InterruptedException, SQLException {
		// Create Project using RestAssured
		RandomNumber ran = new RandomNumber();
		baseURI = "http://rmgtestingserver";
		port = 8084;
		JSONObject ob = new JSONObject();
		ob.put("createdBy", "rathinasurya");
		ob.put("projectName", "API Project" + ran.randomKey());
		ob.put("status", "completed");
		ob.put("teamSize", 4);
		Response resp = given().body(ob).contentType(ContentType.JSON).when().post("/addProject");
		String proId = resp.jsonPath().get("projectId");
		System.out.println(proId);

		// Validate Using Selenium
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://rmgtestingserver:8084/");
		driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[.='Sign in']")).click();
		driver.findElement(By.xpath("//a[.='Projects']")).click();
		String IdList = driver.findElement(By.xpath("//td[.='" + proId + "']")).getText();
		Assert.assertEquals(IdList, proId);
		Reporter.log("project Verified", true);

		// Validate in database
		Connection con = null;
		try {
			Driver driver1 = new Driver();
			DriverManager.registerDriver(driver1);
			con = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects", "root@%", "root");
			Statement state = con.createStatement();
			String query = "select * from project where project_Id='" + proId + "';";
			ResultSet result = state.executeQuery(query);
			while (result.next()) {
				String data = result.getString(1);
				System.out.println(data);
				if (proId.equalsIgnoreCase(data)) {
					System.out.println("project created sucessfully");
				}
			}
		} catch (Exception e) {

		} finally {
			con.close();
		}
		driver.close();

	}
}
