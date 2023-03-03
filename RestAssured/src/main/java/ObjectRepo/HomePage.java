package ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	@FindBy(xpath = "//a[text()='Projects']")
	private WebElement projectsBtn;
	
	@FindBy(linkText = "Logout")
	private WebElement logoutBtn;

public HomePage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}

public WebElement getProjectsBtn() {
	return projectsBtn;
}

public WebElement getLogoutBtn() {
	return logoutBtn;
}

public void clickOnProjBtn()
{
	projectsBtn.click();
}
public void clickOnLogoutBtn()
{
	logoutBtn.click();
}
}
