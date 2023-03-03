package ObjectRepo;

import java.io.FileNotFoundException;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtility.FileUtility;

public class LoginPage {
	@FindBy(id = "usernmae")
	private WebElement unTxtBox;
	
	@FindBy(id = "inputPassword")
	private WebElement pwdTxtBox;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement signinBtn;
	
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getUnTxtBox() {
		return unTxtBox;
	}

	public WebElement getPwdTxtBox() {
		return pwdTxtBox;
	}

	public WebElement getSigninBtn() {
		return signinBtn;
	}

	public void getLoginPage(String username,String password) throws FileNotFoundException
	{
		unTxtBox.sendKeys(username);
		pwdTxtBox.sendKeys(password);
		signinBtn.click();
	}
	
}


