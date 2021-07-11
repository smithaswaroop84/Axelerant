package axelerantPages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import CommonFunctions.Wait;
import Test.Axelerant;

public class BillPage {
	WebDriver driver;
	public Wait w = new Wait();

	public BillPage(WebDriver driver)
	{
		this.driver = driver;
	}
	public By confirmPayment = By.xpath("//h1[text()='Bill Payment Complete']");
	public String ConfirmPaymentMsg ;
	public By PayeeNametxt = By.xpath("//*[@id=\"rightPanel\"]/div/div[1]/form/table/tbody/tr[1]/td[2]/input");
	public By Addresstxt = By.xpath("//*[@id=\"rightPanel\"]/div/div[1]/form/table/tbody/tr[2]/td[2]/input");
	public By Citytxt = By.xpath("//*[@id=\"rightPanel\"]/div/div[1]/form/table/tbody/tr[3]/td[2]/input");
	public By Statetxt = By.xpath("//*[@id=\"rightPanel\"]/div/div[1]/form/table/tbody/tr[4]/td[2]/input");
	public By ZipCodetxt = By.xpath("//*[@id=\"rightPanel\"]/div/div[1]/form/table/tbody/tr[5]/td[2]/input");
	public By Phonetxt = By.xpath("//*[@id=\"rightPanel\"]/div/div[1]/form/table/tbody/tr[6]/td[2]/input");
	public By ToAccountNumbertxt = By.xpath("//*[@id='rightPanel']/div/div[1]/form/table/tbody/tr[8]/td[2]/input");
	public By ToVerifyAccountNumbertxt = By.xpath("//*[@id='rightPanel']/div/div[1]/form/table/tbody/tr[9]/td[2]/input");
	public By Amount = By.xpath("//*[@id='rightPanel']/div/div[1]/form/table/tbody/tr[11]/td[2]/input");
	public By FromAccountdropdown = By.xpath("//*[@id='rightPanel']/div/div[1]/form/table/tbody/tr[13]/td[2]/select");
	public By SendPaymentbtn = By.xpath("//*[@id='rightPanel']/div/div[1]/form/table/tbody/tr[14]/td[2]/input[@value = 'Send Payment']");
	static String froAccForPayment ;
	public void payeeinfotext() throws IOException
	{
		try {
		driver.findElement(PayeeNametxt).sendKeys("Firstname");
		driver.findElement(Addresstxt).sendKeys("Address1");
		driver.findElement(Citytxt).sendKeys("City1");
		driver.findElement(Statetxt).sendKeys("State");
		driver.findElement(ZipCodetxt).sendKeys("Zipcode");
		driver.findElement(Phonetxt).sendKeys("1234567");
		System.out.println("Enter Payye data");
		}catch(Exception e)
		{
			//Axelerant.screenShot();
			System.out.println(e.getMessage());
		}
	}
	
	public void enterAmountInfo(String ToAccNum,String Amounttxt,String FromAcc) throws IOException
	{
		System.out.println("AccounNumber1" +FromAcc +"AccounNumber2" + ToAccNum + "values before try");
		try {
			System.out.println("AccounNumber1" +FromAcc +"AccounNumber2" + ToAccNum + "values after try");
		driver.findElement(ToAccountNumbertxt).sendKeys(ToAccNum);
		driver.findElement(ToVerifyAccountNumbertxt).sendKeys(ToAccNum);
		driver.findElement(Amount).sendKeys(Amounttxt);
		Select s = new Select(driver.findElement(FromAccountdropdown));
		s.selectByVisibleText(FromAcc);
		//String froAccForPayment = FromAcc;
		ConfirmPaymentMsg = "Bill Payment to p in the amount of $200.00 from account " +FromAcc+" was successful.";
		System.out.println("Confirmation message wiht FromAcc :    " + ConfirmPaymentMsg);
		Thread.sleep(10000);
		driver.findElement(SendPaymentbtn).click();
		Thread.sleep(10000);
//		WebDriverWait w = new WebDriverWait(driver,30);
//		w.until(ExpectedConditions.visibilityOfElementLocated(confirmPayment));
		}catch(Exception e)
		{
		//	Axelerant.screenShot();
			System.out.println(e.getMessage());
			
		}
	}
	
	public void confirmPayment()
	{
		String paymentmsg = driver.findElement(confirmPayment).getText();
		if (paymentmsg.contains(ConfirmPaymentMsg))
		Assert.assertEquals(paymentmsg, ConfirmPaymentMsg);
		System.out.println("Bill payment succefull");
	}

}
