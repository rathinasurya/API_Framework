package ThreeLayerTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class GetProjectUsingRestAssured {
	@Test
	public void createAndGetProject() throws SQLException {
		// -------Create Project using selenium------
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://rmgtestingserver:8084/");
		driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[.='Sign in']")).click();
		driver.findElement(By.xpath("//a[.='Projects']")).click();
		driver.findElement(By.xpath("//div[@class='col-sm-6']/button/span[.='Create Project']")).click();
		driver.findElement(By.xpath("//input[@name='projectName']")).sendKeys("getNewProject");
		driver.findElement(By.xpath("//input[@name='createdBy']")).sendKeys("vicky");
		WebElement DD = driver
				.findElement(By.xpath("//label[.='Project Status ']/following-sibling::select[@name='status']"));
		Select s = new Select(DD);
		s.selectByValue("Completed");
		driver.findElement(By.xpath("//input[@value='Add Project']")).click();

		String id = driver.findElement(By.xpath("//td[.='getNewProject']/../td[1]")).getText();
		System.out.println(id);

		// Get the particular project using RestAssured
		baseURI = "http://rmgtestingserver";
		port = 8084;
		when().get("/projects/" + id + "").then().assertThat().statusCode(200).contentType(ContentType.JSON).log()
				.all();

		// validate the project in database
		Connection con = null;
		try {
			Driver driver1 = new Driver();
			DriverManager.registerDriver(driver1);
			con = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects", "root@%", "root");
			Statement state = con.createStatement();
			String query = "select * from project where project_Id='" + id + "';";
			ResultSet result = state.executeQuery(query);
			while (result.next()) {
				String data = result.getString(1);
				// System.out.println(data);
				if (id.equalsIgnoreCase(data)) {
					System.out.println("project created sucessfully");
				}
			}
		} catch (Exception e) {

		} finally {
			con.close();
		}

		// Delete the project using RestAssured
		when().delete("http://rmgtestingserver:8084/projects/" + id + "").then().assertThat().statusCode(204)
				.contentType(ContentType.JSON).log().all();

	}
}
