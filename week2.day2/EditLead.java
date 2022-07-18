package week2.day2.assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver=new ChromeDriver();
		
		//Launch the browser
		driver.get("http://leaftaps.com/opentaps/control/main");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.manage().window().maximize();
		
		//Enter the username
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
				
		//Enter the password
		driver.findElement(By.id("password")).sendKeys("crmsfa");
				
		//Click Login
		driver.findElement(By.className("decorativeSubmit")).click();
				
		//Click crm/sfa link
		driver.findElement(By.linkText("CRM/SFA")).click();
				
		//Click Leads link
		driver.findElement(By.linkText("Leads")).click();
		
		//Click Find leads
		driver.findElement(By.linkText("Find Leads")).click();
		
		//Enter first name
		driver.findElement(By.xpath("//div[@class='x-form-item x-tab-item']//label[text()='First name:']/following::input[@name='firstName']")).sendKeys("Indhumathi");
		
		//Click Find leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		//Click on first resulting lead
		//driver.findElement(By.linkText("11196")).click();
		driver.findElement(By.linkText("11196")).click();
		
		//Verify title of the page
		String title = driver.getTitle();
		
		if(title.equals("View Lead | opentaps CRM"))
		{
			System.out.println("Verified Successfully");
		}
		
		//Click Edit
		driver.findElement(By.xpath("//a[text()='Edit']")).click();
		
		//Change the company name
		driver.findElement(By.id("updateLeadForm_companyName")).clear();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys("ABC");
		
		//Click Update
		driver.findElement(By.xpath("//input[@value='Update']")).click();
		
		//Confirm the changed name appears
		String changed_name = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		
		if(changed_name.equals("ABC (11196)"))
		{
			System.out.println("Company name changed successfully");
		}
		
		//Close the browser (Do not log out)
		driver.close();
	}

}
