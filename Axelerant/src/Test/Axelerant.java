package Test;

import CommonFunctions.Wait;
import axelerantPages.AccountDetailPage;
import axelerantPages.AccountOverViewPage;
import axelerantPages.Accountnew;
import axelerantPages.BillPage;
import axelerantPages.NewAccountDetailPage;
import axelerantPages.SignIn;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.*;
//import org.apache.logging.log4j.core.util.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;

public class Axelerant {
	public 	String URL = "https://parabank.parasoft.com/parabank/billpay.htm";
	String Key = "Webdriver.chrome.driver";
	String value = "/home/smitha/Downloads/SeleniumClient/chromedriver_win32/chromedriver";
	static String AccounNumber1;
	static String AccounNumber2;
	static String AccAvaiable1;
	static String AccBalance1 ;
	static String getAccNumber1 ;
	static String getAccType1;
	static String getTitleaccNumber1 ;
	static String AccAvaiable2;
	static String AccBalance2 ;
	static String getAccNumber2 ;
	static String getAccType2;
	static String getTitleaccNumber2;
	public static WebDriver driver;
	public static String fileWithPath = "/home/smitha/eclipse-workspace/Axelerant/ScreenShot/Shot.png";
	@BeforeMethod
	public void LaunchBrowser()
	{
		System.setProperty(Key,value);
		driver = new ChromeDriver();
		driver.get(URL); 	
	}
//Automate A and B of assignment A	
  @Test(priority =1)
 // @Test(enabled =false)
  public void assingnmetAB() throws Exception{

		try
		{
			SignIn SignInPage = new SignIn(driver);
			NewAccountDetailPage Adp = new NewAccountDetailPage(driver);
			Accountnew An = new Accountnew(driver);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			Wait w = new Wait();
			SignInPage.setUserName("john");
			Reporter.log("Entered User Name");
			SignInPage.setPassowrd("demo");
			SignInPage.getErrorTextInLogin();
			SignInPage.clickLoginBtn();
			SignInPage.verifyTitle();
//Checking account creation
			An.OpenLinkAcc();
			An.selectDrop("CHECKING");
			An.selectDropAmount("13344");
			An.ClickonOpenNewAccount();
			Thread.sleep(5000);
			AccounNumber1 = An.getNewAccount();
			An.ClickOnCreatedAccount();
			Thread.sleep(10000);
			AccAvaiable1 = Adp.getAccountAvailable();
			AccBalance1 = Adp.getAccountBalance();
			getAccNumber1 = Adp.getAccountNumber();
			getAccType1 = Adp.getAccountType();
			Adp.validate(AccAvaiable1,"$100.00","Available");
			Adp.validate(AccBalance1,"$100.00","Balance ");
			Adp.validate(getAccType1,"CHECKING","Account Type");
			System.out.println("AccounNumber1Availbleamount : "+AccAvaiable1 +" AccBalance1 : " + AccBalance1);
			System.out.println("AccounNumber1 : "+getAccNumber1 +" AccType1 :" + getAccType1);
//			Adp.getTitleofAccDetailPage();
//Saving account creation	
			Thread.sleep(5000);
			An.OpenLinkAcc();
			An.selectDrop("SAVINGS");
			An.selectDropAmount("13566");
			An.ClickonOpenNewAccount();
			Thread.sleep(5000);
			AccounNumber2 = An.getNewAccount();
			An.ClickOnCreatedAccount();
			Thread.sleep(10000);
			AccAvaiable2 = Adp.getAccountAvailable();
			AccBalance2 = Adp.getAccountBalance();
			getAccNumber2 = Adp.getAccountNumber();
			getAccType2 = Adp.getAccountType();
			Adp.validate(AccAvaiable2,"$100.00", "Available ");
			Adp.validate(AccBalance2,"$100.00", "Balance");
			Adp.validate(getAccType2,"CHECKING", "Account Type");
			System.out.println("AccounNumber2Availbleamount : "+AccAvaiable2 +" AccBalance2 : " + AccBalance2);
			System.out.println("AccounNumber2 : "+getAccNumber2 +" AccType2 :" + getAccType2);
	//		Adp.getTitleofAccDetailPage();
			
		} 
		catch(Exception e)
		{
			//takeSnapShot(driver, fileWithPath);
			System.out.println(e.getMessage());
		}
	 }
  
//Automate Bill Pay  
  
  @Test(dependsOnMethods = { "assingnmetAB" })
  //@Test(enabled = true)
  public void assingnmetC() throws Exception{

		try
		{
			System.out.println("test2");
			SignIn SignInPage = new SignIn(driver);
			//AccountDetailPage Adp = new AccountDetailPage(driver);
			AccountDetailPage AccDp = new AccountDetailPage(driver);
			AccountOverViewPage AOOP = new AccountOverViewPage(driver);
			Accountnew An = new Accountnew(driver);
			BillPage bp = new BillPage(driver);
			AccountDetailPage ADP = new AccountDetailPage(driver);
			AccountOverViewPage AOV = new AccountOverViewPage(driver);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			Wait w = new Wait();
			SignInPage.setUserName("john");
			Reporter.log("Entered User Name");
			SignInPage.setPassowrd("demo");
			SignInPage.clickLoginBtn();

			An.ClickonBilPayLink();
			bp.payeeinfotext();
			//Toacco --Account1 , From Acc --Acc2
			System.out.println("AccounNumber1 : " +AccounNumber1 +"AccounNumber2 : " + AccounNumber2 + "values before payment");
			bp.enterAmountInfo(AccounNumber1, "200", AccounNumber2);
			bp.confirmPayment();

			AOOP.clickonAccOOL();
			Thread.sleep(10000);
			AOOP.selectAccfromTable(AccounNumber1);
			Thread.sleep(5000);
       		ADP.getAccountInfo("$100.00","$100.00");
    		ADP.getTablecontent(1);
	    		
			AOOP.clickonAccOOL();
			Thread.sleep(10000);
			AOOP.selectAccfromTable(AccounNumber2);
			Thread.sleep(5000);
       		ADP.getAccountInfo("-$100.00","$0.00");
    		ADP.getTablecontent(2);
  		
    		
		} 
		catch(Exception e)
		{
			//takeSnapShot(driver, fileWithPath);
			System.out.println(e.getMessage());
		}
	 }
  @AfterMethod
	//public static void takeSnapShot(WebDriver driver,String fileWithPath) throws Exception
  public static void screenShot(ITestResult result) throws IOException
  //public static void screenShot() throws IOException
	{
	//	if (ITestResult.FAILURE == result.getStatus()) 
		//{
			try 
			{
				TakesScreenshot scrShot =((TakesScreenshot)driver);
				File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
				//File DestFile=new File("/home/smitha/eclipse-workspace/Axelerant/ScreenShot/Shot.png");
				File DestFile=new File("/home/smitha/eclipse-workspace/Axelerant/ScreenShot/" + result.getName()+ ".png");
				//System.out.println(result.getName()+ "Name of The testcase");
				FileUtils.copyFile(SrcFile,DestFile);
			}catch (Exception e)
			{
				System.out.println("Exception while taking the screen shot"+e.getMessage());
			}
	//	}
		//FileUtils
	}
  
  
  @AfterMethod
  public void AfterTest() {
	driver.quit(); 
	  
  }

}
