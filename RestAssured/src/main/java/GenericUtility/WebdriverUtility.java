package GenericUtility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class WebdriverUtility {
public void select(WebElement element,String value)
{
	Select s=new Select(element);
	s.selectByValue(value);
}
public void select(String visibleText, WebElement element)
{
	Select s=new Select(element);
	s.selectByVisibleText(visibleText);
}
public void select(WebElement element,int index)
{
	Select s=new Select(element);
	s.selectByIndex(index);
}
public void maximizeWindow(WebDriver driver)
{
	driver.manage().window().maximize();
}

public void waitForPageLoad(WebDriver driver)
{
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
}
}