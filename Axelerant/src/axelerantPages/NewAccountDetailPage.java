package axelerantPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import CommonFunctions.Wait;

public class NewAccountDetailPage {
	WebDriver driver;
	public NewAccountDetailPage(WebDriver driver)
	{
		this.driver = driver;
	}
	public By AccountNumber = By.xpath("//table/tbody/tr[1]/td[2]");
	public By AccountType = By.xpath("//td[@id = 'accountType']");
	public By AccountBalance = By.xpath("//table/tbody/tr[3]/td[2]");
	public By AccountAvailable = By.xpath("//table/tbody/tr[4]/td[2]");
	
	public String getAccountNumber()
	{
		return driver.findElement(AccountNumber).getText();
	}
	public void validate(String Actual, String Expected,String message)
	{
	if (Expected.contains(Actual)) {
		//Assert.assertEquals(Actual, Expected);
		System.out.println(message + "The actual :  " + Actual+ "The expected  :  " + Expected+ "are same");
	}
	}
	
	public String getAccountType()
	{
		return driver.findElement(AccountType).getText();
	}
	public String getAccountBalance()
	{
		return driver.findElement(AccountBalance).getText();
	}
	public String getAccountAvailable()
	{
		return driver.findElement(AccountAvailable).getText();
	}
	public void getTitleofAccDetailPage()
	{
		String title = driver.getTitle();
		String TitleAccValue = title.replaceAll("[0-9]", "");
		
		//System.out.println(title);
		//return title;		
	}
	
	

}
