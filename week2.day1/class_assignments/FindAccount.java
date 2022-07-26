package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindAccount {

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
		
		//Click on Find Accounts
		driver.findElement(By.linkText("Find Accounts")).click();
		
		//Enter AccountName as "Credit Limited Account" 
		driver.findElement(By.xpath("(//input[@name='accountName'])[2]")).sendKeys("Credit Limited Account");
		
		//Click on Find Accounts using xpath Locator
		driver.findElement(By.xpath("//button[text()='Find Accounts']")).click();
		
		//Click on the edit Button
		driver.findElement(By.linkText("Credit Limited Account")).click();
		driver.findElement(By.xpath("//div/a[text()='Edit']")).click();
		
		//10. Get the Text of Account Name and verify 
		String accValue = driver.findElement(By.xpath("//td/input[@id='accountName']")).getAttribute("value");
		
		if(accValue.equals("Credit Limited Account"))
		{
			System.out.println("Verified account name successfully");
		}
		
		//Get the Text of Description
		String descValue = driver.findElement(By.xpath("//textarea[@name='description']")).getText();
		System.out.println(descValue);
		
		//Get the title of the page and verify it.
		String title = driver.getTitle();
		if(title.equals("Edit Account | opentaps CRM"))
		{
			System.out.println("Verified title "+title);
		}

	}

}
