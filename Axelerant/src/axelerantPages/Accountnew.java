package axelerantPages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import CommonFunctions.Wait;
import Test.Axelerant;

public class Accountnew {
	
	WebDriver driver;
	public Wait w = new Wait();
	

	public Accountnew(WebDriver driver)
	{
		this.driver = driver;
	}
	public By OpenNewAccountLink = By.xpath("//a[@href = '/parabank/openaccount.htm' and text() = 'Open New Account']");
	public By AccountTypeSelect = By.xpath("//*[@id=\"type\"]");
	public By AmountSelect = By.xpath("//select[@id=\"fromAccountId\"]");
	public By OpenNewAccountBtn = By.xpath("//input[@type = 'submit']");
	public By NewAccountTxt = By.xpath("//a[@id = 'newAccountId']");
	public By BillPayLink = By.xpath("//a[@href = '/parabank/billpay.htm' and text() = 'Bill Pay']");	

	
	public void OpenLinkAcc() 
	{
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(OpenNewAccountLink).click();
	}
	
	public void selectDrop(String Value) throws IOException
	{
		try
		{
		Select s  = new Select(driver.findElement(AccountTypeSelect));
		s.selectByVisibleText(Value);
		}
		catch(Exception e )
		{
			System.out.println("e.message");
			//Axelerant.screenShot();
		}
	}
	
	public void selectDropAmount(String Value)
	{
		Select s  = new Select(driver.findElement(AmountSelect));
		s.selectByVisibleText(Value);
	}
	public void ClickonBilPayLink()
	{
		driver.findElement(BillPayLink).click();
		System.out.println("Clicked on Bill Pay link");
	}
	
	
	public void ClickonOpenNewAccount()
	{
		driver.findElement(OpenNewAccountBtn).click();
	}
	
	public String getNewAccount()
	{
		String AccountNumber= driver.findElement(NewAccountTxt).getText();
		System.out.println("Created account" + AccountNumber);
		return AccountNumber;
	}
	
	public void ClickOnCreatedAccount()
	{
		driver.findElement(NewAccountTxt).click();
	}
}
