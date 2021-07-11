package CommonFunctions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import axelerantPages.SignIn;

public  class Wait{
	
	WebDriver driver;
	/*	SignIn s = new SignIn(driver);
	public Wait(WebDriver driver)
	{
		this.driver = driver;
	}*/
	
	public void implicitWait(int Time)
	{
		driver.manage().timeouts().implicitlyWait(Time, TimeUnit.SECONDS);
	}
	public void ExplicitWait()
	{
		WebDriverWait d = new WebDriverWait(driver,30);
		//d.until(ExpectedConditions.presenceOfElementLocated(s.UserName));
	}
	
	
	
	public void click(By Locator)
	{
		driver.findElement(Locator).click();
	}
	public void SendKeys(By Locator, String Value)
	{
		driver.findElement(Locator).sendKeys(Value);
	}
	public String GetText(By Locator)
	{
		String Text = driver.findElement(Locator).getText();
		return Text;
	}
	
	

}
