package axelerantPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class AccountDetailPage {
	
	WebDriver driver;
	public AccountDetailPage(WebDriver driver)
	{
		this.driver = driver;
	}
	//public By TransactionTbl = By.xpath("//table[@id='transactionTable']/tbody");	
	public By TransactionTbl = By.xpath("//table[@id='transactionTable']/tbody");
	public By AccountNumber = By.xpath("//td[@id='accountId']");
	public By AccountType = By.xpath("//td[@id='accountType']");
	public By AccountBalance = By.xpath("//td[@id='balance']");
	public By AccountAvailable = By.xpath("//td[@id='availableBalance']");
	public String Debit;
	public String credit;
	public String Debit2;
	public String credit2;
	public By TransactionTblRW = By.xpath("//table[@id='transactionTable']/tbody/tr");
	
	
	
	public void getAccountInfo(String Balance, String Available)
	{

				String AccountNumberval = driver.findElement(AccountNumber).getText();
				String AccountTypeval = driver.findElement(AccountType).getText();
				String AccountBalanceval = driver.findElement(AccountBalance).getText();
				String AccountAvailableval = driver.findElement(AccountAvailable).getText();
				if (Balance.equals(AccountBalanceval) && Available.equals(AccountAvailableval))
				{
					System.out.println("Balance value in " + AccountNumberval + "are same");
//					System.out.println();
					
				}else 
				{
					System.out.println("Balancevalue are showing different in the Account " +AccountNumberval);
				}
//		System.out.println(AccountNumberval + AccountTypeval+ AccountBalanceval+ AccountAvailableval);
		
	}
	
	public void getTablecontent(int AccountNumber)
	{
		WebElement TogetRows = driver.findElement(TransactionTbl);
		List<WebElement>TotalRowsList = TogetRows.findElements(By.tagName("tr"));
		System.out.println("Total number of Rows in the table are : "+ TotalRowsList.size());
		int RowCount = TotalRowsList.size();
		
		WebElement ToGetColumns = driver.findElement(TransactionTblRW);

		List<WebElement> TotalColsList = ToGetColumns.findElements(By.tagName("td"));

/*		  for (int i =1; i<TotalRowsList.size(); i++)
	        {   
	        	String max;
	        	double m=0,r =0;*/
//	        	Debit = driver.findElement(By.xpath("//table[@id='transactionTable']/tbody/tr[" + (i+1)+ "]/td[3]")).getText();
//	        	credit = driver.findElement(By.xpath("//table[@id='transactionTable']/tbody/tr[" + (i+1)+ "]/td[4]")).getText();
 
		String TransactioExpected = "Funds Transfer Received";
					switch(AccountNumber) {
					case 2 :
						//From Account
						String credVal = "$100.00";
						String Debtval = "$200.00";
				//		String TransactioExpected = "Funds Transfer Received";
						String TransactionbillExpected = "Bill Payment to Firstname";
				    	Debit = driver.findElement(By.xpath("//table[@id='transactionTable']/tbody/tr[2]/td[3]")).getText();
				    String TransactionType =driver.findElement(By.xpath("//table[@id='transactionTable']/tbody/tr[1]/td[2]")).getText();
				    String TransactionTypeBill =driver.findElement(By.xpath("//table[@id='transactionTable']/tbody/tr[2]/td[2]")).getText();
				      //	credit = driver.findElement(By.xpath("//table[@id='transactionTable']/tbody/tr[2]/td[4]")).getText();
				      //	Debit2 = driver.findElement(By.xpath("//table[@id='transactionTable']/tbody/tr[3]/td[3]")).getText();
				      	credit2 = driver.findElement(By.xpath("//table[@id='transactionTable']/tbody/tr[1]/td[4]")).getText();
				      	
				      //	if(credit = "$100" && Debit2 = "$-200")
				      	if(credit2.equals(credVal)&& Debit.equals(Debtval))
				      		{System.out.println("The credit and debit Values are as expected");}
				      	else 
				      		{System.out.println("The credit and debit Values are not as expected");		}	
				      	if(TransactioExpected.equals(TransactionType)&& TransactionbillExpected.equals(TransactionTypeBill))
			      		{System.out.println("The transaction type " + TransactioExpected+"   "+TransactionbillExpected + "type  are as expected");}
				      	else 
			      		{System.out.println("The transaction type " + TransactioExpected+"   "+TransactionbillExpected + "type  are not as expected");		}	
			
						break;
					case 1 :
						System.out.println("Before");
						//For To account	
						String credVal1 = "$100.00";
						
				    //	Debit = driver.findElement(By.xpath("//table[@id='transactionTable']/tbody/tr/td[3]")).getText();
				      	credit = driver.findElement(By.xpath("//*[@id='transactionTable']/tbody/tr[1]/td[4]")).getText();
				      String transactionType = driver.findElement(By.xpath("//*[@id='transactionTable']/tbody/tr[1]/td[2]")).getText();
				      	//if(credit.equals(credVal1)&& Debit.isEmpty())
				      	if(credit.equals(credVal1))
				      		System.out.println("The credit and debit Values are as expected");
				      	else System.out.println("The credit and debit Values are not as expected");
				      	
				    	if(TransactioExpected.equals(transactionType))
			      		{System.out.println("The transaction type " + TransactioExpected+" are as expected");}
				      	else 
			      		{System.out.println("The transaction type " + TransactioExpected+"  are not as expected");		}	
			
						break;
					default : System.out.println("not a valid account");break;
					}     	

	       	
//	        }
		}
	
}