package axelerantPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;

import CommonFunctions.Wait;
import Test.Axelerant;

public class TransferFundPage {
	WebDriver driver;
	Wait w = new Wait();
	public TransferFundPage(WebDriver driver)
	{
		this.driver = driver;
	}
	public By TransferFund = By.xpath("//*[@id='leftPanel']/ul/li[3]/a");
	public By FromAcc = By.xpath("//select[@id='fromAccountId']");
	public By ToAcc = By.xpath("//select[@id='toAccountId']");
	public By Amount = By.xpath("//input[@id='amount']");
	public By TransferBtn = By.xpath("//input[@type='submit']");	
	Axelerant al= new Axelerant();

			public void clickOnTransferFundLink(String UN)
			 {
				 driver.findElement(TransferFund).click();
			 }
			 
			 public void EnterAmountTransfer(String AmountVal,String FromAccNum, String ToAccNum)
			 {
				 driver.findElement(Amount).sendKeys(AmountVal);
				 Select s = new Select(driver.findElement(FromAcc));
				 s.selectByVisibleText(FromAccNum);
				 Select st = new Select(driver.findElement(ToAcc));
				 st.selectByVisibleText(ToAccNum);
			 }
			 public void clickOnTransferFundBtn()
			 {
				 driver.findElement(TransferBtn).click();
			 }
	}
