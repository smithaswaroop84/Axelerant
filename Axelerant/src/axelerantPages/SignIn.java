package axelerantPages;
import Test.Axelerant;

import org.testng.IReporter;
import org.testng.Reporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import CommonFunctions.Wait;
import Test.Axelerant;
public class SignIn {
	
	WebDriver driver;
	Wait w = new Wait();
	public SignIn(WebDriver driver)
	{
		this.driver = driver;
	}
	public By UserName = By.xpath("//input[@name = 'username']");
	public By password = By.xpath("//input[@name = 'password']");
	public By Loginbtn = By.xpath("//input[@value = 'Log In']");
	public By Errortext = By.xpath("//*[@id='rightPanel']/p[contains(text(),'An internal error has occurred and has been logged.')]");
	//public By Errortext = By.xpath("//*[@id='rightPanel']/p[contains(text(),'An ')]");
	public String errormessageLogin = "An internal error has occurred and has been logged.";
	public String TitleExpected = "ParaBank | Accounts Overview";
	public static String fileWithPath = "/home/smitha/eclipse-workspace/Axelerant/ScreenShot/Shot.png";
	Axelerant al= new Axelerant();

			public void setUserName(String UN)
			 {
				 driver.findElement(UserName).sendKeys(UN);
			 }
			 
			 public void setPassowrd(String pwd)
			 {
				 driver.findElement(password).sendKeys(pwd);
			 }
			 public void clickLoginBtn()
			 {
				 driver.findElement(Loginbtn).click();
			 }
			 public void getErrorTextInLogin()
			 {
				 if (driver.findElement(Errortext).isDisplayed())
				 {
					 String ErrorMessage = driver.findElement(Errortext).getText();
					 Assert.assertEquals(ErrorMessage, errormessageLogin, "Login page Error Exist");
					 Reporter.log("Found Error in the log page");
				 }
			 }
			 public void verifyTitle() throws Exception
			 {
				 try {
				String Title = driver.getTitle();
				Assert.assertEquals(Title, TitleExpected, "home page is displayed");}
				 catch(Exception e )
				 {
					System.out.println(e.getMessage());
					// Axelerant.takeSnapShot(driver, fileWithPath);
					//al.screenShot(result);
				 }
				 
			 }
	
	 
}
