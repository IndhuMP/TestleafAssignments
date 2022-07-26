package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NTCreateAccount {

	public static void main(String[] args) {
		
WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		
		 //Launch URL "http://leaftaps.com/opentaps/control/login"
		driver.get("http://leaftaps.com/opentaps/control/login");
		
		//maximize the window
		driver.manage().window().maximize();
				
		// Enter UserName and Password Using Id Locator
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		
		// Click on Login Button using Class Locator
		driver.findElement(By.className("decorativeSubmit")).click();
	
		//Click on CRM/SFA Link
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		// Click on Accounts Button
		driver.findElement(By.linkText("Accounts")).click();
		
		// Click on Create Account
		driver.findElement(By.linkText("Create Account")).click();

		//Enter AccountName Field Using Xpath Locator value as Debit Limited Account
		 driver.findElement(By.xpath("//input[@id='accountName']")).sendKeys("Debit Limited Account");
		  
		//Enter DEscriptiion as "Selenium Automation Tester"
		 driver.findElement(By.xpath("//textarea[@name='description']")).sendKeys("Selenium Automation Tester");
		 
		 //Enter LocalName Field Using Xpath Locator
		 driver.findElement(By.xpath("//input[@id='groupNameLocal']")).sendKeys("indhu");
		 
		 //Enter SiteName Field Using Xpath Locator
		 driver.findElement(By.xpath("//input[@id='officeSiteName']")).sendKeys("XYZ");
		 
		 //Enter value for AnnualRevenue Field using Xpath Locator but class as Attribute
		 driver.findElement(By.xpath("(//input[@class='inputBox'])[5]")).sendKeys("1000");
		 
		 //Select Industry as ComputerSoftware
		 WebElement industryDrop = driver.findElement(By.name("industryEnumId"));
		 Select selIndus = new Select(industryDrop);
		 selIndus.selectByValue("IND_FINANCE");
		 
		 //Select OwnerShip as S-Corporation using SelectByVisibletext
		 WebElement ownerDrop = driver.findElement(By.name("ownershipEnumId"));
		 Select selOwner = new Select(ownerDrop);
		 selOwner.selectByVisibleText("S-Corporation");
		 
		 //Select Source as Employee using SelectByValue
		 WebElement sourceDrop = driver.findElement(By.id("dataSourceId"));
		 Select selSource = new Select(sourceDrop);
		 selSource.selectByValue("LEAD_EMPLOYEE");
		 
		 //Select Marketing Campaign as eCommerce Site Internal Campaign using SelectbyIndex
		 WebElement marketDrop = driver.findElement(By.id("marketingCampaignId"));
		 Select selMarket = new Select(marketDrop);
		 selMarket.selectByIndex(6);
		 
		 //Select State/Province as Texas using SelectByValue
		 WebElement stateDrop = driver.findElement(By.id("generalStateProvinceGeoId"));
		 Select selState = new Select(stateDrop);
		 selState.selectByValue("TX");
		 
	    //Click on Create Account using Xpath Locator
		 driver.findElement(By.xpath("//input[@class='smallSubmit']")).click();
		 
         // 15.Close the browser
		//driver.close();
               
	}

}
