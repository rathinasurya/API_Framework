package ThreeLayerTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

import PojoClass.PojoClass;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class CreateProjectUsingPojoClass {
	@Test
	public void validateProjectDB() throws SQLException {
		// Create Project Using Pojo class
		PojoClass p = new PojoClass("vijay", "TYSS_HM12", "pass", 8);
		baseURI = "http://rmgtestingserver";
		port = 8084;
		Response resp = given().body(p).contentType(ContentType.JSON).when().post("/addProject");
		String proId = resp.jsonPath().get("projectId");
		System.out.println(proId);

		// validate Project using selenium
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

		// Delete Project in DataBase
		Connection con = null;
		try {
			Driver driver1 = new Driver();
			DriverManager.registerDriver(driver1);
			con = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects", "root@%", "root");
			Statement state = con.createStatement();
			String query = "Delete from project where project_Name='TYSS_HM12';";
			int result = state.executeUpdate(query);
			if (result == 1) {
				System.out.println("Project is deleted");
			} else {
				System.out.println("project is not deleted");
			}
		} catch (Exception e) {

		} finally {
			con.close();
		}

	}

}
