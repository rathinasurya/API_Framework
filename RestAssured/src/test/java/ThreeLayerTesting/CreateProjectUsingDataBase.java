package ThreeLayerTesting;

import static io.restassured.RestAssured.when;

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

import io.restassured.http.ContentType;

public class CreateProjectUsingDataBase {
	@Test
	public void createproject() throws SQLException {
		// Create project using DataBase
		Connection con = null;
		try {
			Driver driver1 = new Driver();
			DriverManager.registerDriver(driver1);
			con = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects", "root@%", "root");
			Statement state = con.createStatement();
			String query = "Insert into project values('TYSS_HMS_089','surya','27-2-2023','Hospital_API_Project','created','12')";
			state.executeUpdate(query);
		} catch (Exception e) {

		} finally {
			con.close();
		}

		// validate project using selenium
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://rmgtestingserver:8084/");
		driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[.='Sign in']")).click();
		driver.findElement(By.xpath("//a[.='Projects']")).click();
		boolean data = driver.findElement(By.xpath("//td[.='Hospital_API_Project']")).isDisplayed();
		Assert.assertTrue(data);
		Reporter.log("Project created sucessfully and displayed in GUI", true);

		// Delete project using RestAssured
		when().delete("http://rmgtestingserver:8084/projects/TYSS_HMS_089").then().assertThat().statusCode(204)
				.contentType(ContentType.JSON).log().all();

	}

}
