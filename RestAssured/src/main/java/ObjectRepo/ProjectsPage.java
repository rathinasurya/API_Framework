package ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtility.ExcelUtility;
import GenericUtility.JavaLibrary;
import GenericUtility.WebdriverUtility;

public class ProjectsPage extends WebdriverUtility {
@FindBy(xpath = "//span[.='Create Project']")
private WebElement clickOnCreateProjectBtn;

@FindBy(xpath = "//input[@name='projectName']")
private WebElement projNameTxtBox;

@FindBy(xpath = "//input[@name='createdBy']")
private WebElement projManagerTxtBox;

@FindBy(xpath = "//label[.='Project Status ']/following-sibling::select[@name='status']")
private WebElement projStatusDD;

@FindBy(xpath = "//input[@value='Add Project']")
private WebElement addProjectBtn;

public ProjectsPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}

public WebElement getClickOnCreateProjectBtn() {
	return clickOnCreateProjectBtn;
}

public WebElement getProjNameTxtBox() {
	return projNameTxtBox;
}

public WebElement getProjManagerTxtBox() {
	return projManagerTxtBox;
}

public WebElement getProjStatusDD() {
	return projStatusDD;
}

public WebElement getAddProjectBtn() {
	return addProjectBtn;
}


public void createNewProject(String ProjectName,String createdBy, String status) throws Throwable
{
	clickOnCreateProjectBtn.click();
	projNameTxtBox.sendKeys(ProjectName);
	projManagerTxtBox.sendKeys(createdBy);
	select(projStatusDD,  status);
	addProjectBtn.click();
	
}


}
