package axelerantPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import CommonFunctions.Wait;

public class AccountServiceLink {
	
	WebDriver driver;
	public Wait w = new Wait();

	public AccountServiceLink(WebDriver driver)
	{
		this.driver = driver;
	}
	public By BillPayLink = By.xpath("//a[@href = '/parabank/billpay.htm']");
	public By TransferFund = By.xpath("//a[@href = '/parabank/transfer.htm']");
	

}
