package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContact {

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
		
		//Click on contacts Button
		driver.findElement(By.linkText("Contacts")).click();
		
		//Click on Create Contact
		driver.findElement(By.linkText("Create Contact")).click();
		
		//Enter FirstName Field Using id Locator
		driver.findElement(By.id("firstNameField")).sendKeys("Indhumathi");
		
		//Enter LastName Field Using id Locator
		driver.findElement(By.id("lastNameField")).sendKeys("Mohan");
		
		//Enter FirstName(Local) Field Using id Locator
		driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys("Indhu");
		
		//Enter LastName(Local) Field Using id Locator
		driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys("M");
		
		//Enter Department Field Using any Locator of Your Choice
		driver.findElement(By.id("createContactForm_departmentName")).sendKeys("Mech");
		
		//Enter Description Field Using any Locator of your choice 
		driver.findElement(By.id("createContactForm_description")).sendKeys("Test case preparation");
		
		//Enter your email in the E-mail address Field using the locator of your choice
		driver.findElement(By.id("createContactForm_primaryEmail")).sendKeys("indhumohan@g.com");
		
		//Select State/Province as NewYork Using Visible Text
		WebElement drop = driver.findElement(By.id("createContactForm_generalStateProvinceGeoId"));
		
		//create a select class
		Select select = new Select(drop);
		
		select.selectByVisibleText("New York");
		
		//Click on Create Contact
		driver.findElement(By.className("smallSubmit")).click();
		
		//Click on edit button 
		driver.findElement(By.className("subMenuButton")).click();
		
		//Clear the Description Field using .clear
		driver.findElement(By.id("updateContactForm_description")).clear();
		  
		//Fill ImportantNote Field with Any text
		driver.findElement(By.id("updateContactForm_importantNote")).sendKeys("Testing automation");
		
		// Click on update button using Xpath locator
		driver.findElement(By.xpath("//input[@value='Update']")).click();
		 
		//Get the Title of Resulting Page.
		String title = driver.getTitle();
		
		System.out.println(title);
		
		if(title.equals("View Contact | opentaps CRM"))
		{
			System.out.println("Added successfully");
		}
	}

}
