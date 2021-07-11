package axelerantPages;


import java.text.NumberFormat;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



import Test.Axelerant;
//import axelerantPages.AccountDetailPage;
public class AccountOverViewPage {
	
	WebDriver driver;
	public AccountOverViewPage(WebDriver driver)
	{
		this.driver = driver;
	}
	public By AccOverViewLink = By.xpath("//*[@id='leftPanel']/ul/li[2]/a[text()='Accounts Overview']");
	public By AccOverviewTableRw = By.xpath("//table[@id='accountTable']/tbody/tr");
	public By AccOverviewTable = By.xpath("//table[@id='accountTable']/tbody");
	public String AccountNumber1 ;
	public String BalanceAmount ;
	public String AvailableAmount ;
	Axelerant al= new Axelerant();
	
	
	public void clickonAccOOL()
	{
		driver.findElement(AccOverViewLink).click();
		System.out.println("Clicked on Account over view link");
	}

	public void selectAccfromTable(String AccounNumber)
	{
		System.out.println("To select the account from Account overview summary");
		WebElement TogetRows = driver.findElement(AccOverviewTable);
		List<WebElement>TotalRowsList = TogetRows.findElements(By.tagName("tr"));
		System.out.println("Total number of Rows in the Account over view table are : "+ TotalRowsList.size());
		int RowCount = TotalRowsList.size();
		
		WebElement ToGetColumns = driver.findElement(AccOverviewTableRw);
		

		List<WebElement> TotalColsList = ToGetColumns.findElements(By.tagName("td"));

		System.out.println("Total Number of Columns in the Account over view table are: "+TotalColsList.size());
		int ColCount = TotalColsList.size();
        for (int i =1; i<TotalRowsList.size(); i++)
        {   
        	String max;
        	double m=0,r =0;
        	AccountNumber1 = driver.findElement(By.xpath("//*[@id='accountTable']/tbody/tr[" +(i) +"]/td[1]/a")).getText();
        	BalanceAmount = driver.findElement(By.xpath("//*[@id='accountTable']/tbody/tr[" +(i) +"]/td[2]")).getText();
        	AvailableAmount = driver.findElement(By.xpath("//*[@id='accountTable']/tbody/tr[" +(i) +"]/td[3]")).getText();
  /*       	NumberFormat f =NumberFormat.getNumberInstance(); 
            Number s = f.parse(BalanceAmount);
            max = s.toString();
            m = Double.parseDouble(max);
            if(m>r)
             {    
                r=m;
             }*/
        	if (AccountNumber1.equals(AccounNumber))
        	{
          		driver.findElement(By.xpath("//*[@id='accountTable']/tbody/tr[" +(i) +"]/td[1]/a")).click();
          		System.out.println(AccountNumber1 + " account number is selected and clicked");
        		break;
         	}
        	
        }
		
	}
	
	 
}
