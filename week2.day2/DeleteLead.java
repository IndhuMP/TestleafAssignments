package week2.day2.assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {

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
		
		//Click on Phone
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		
		//Enter phone number
		driver.findElement(By.xpath("//input[@name='phoneAreaCode']")).sendKeys("91");
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("1000");
		
		//Click find leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		//Capture lead ID of First Resulting lead
		driver.findElement(By.linkText("13492")).click();
		
		//Click Delete
		driver.findElement(By.xpath("//a[@class='subMenuButtonDangerous']")).click();
		
		//Click Find leads
		driver.findElement(By.linkText("Find Leads")).click();
		
		//Enter captured lead ID
		driver.findElement(By.xpath("//label[text()='Lead ID:']/following::input[@name='id']")).sendKeys("13492");
				
		//Click find leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		//Verify message "No records to display" in the Lead List. This message confirms the successful deletion
		String no_record = driver.findElement(By.xpath("(//div[text()='No records to display'])[1]")).getText();
		
		if(no_record.equals("No records to display"))
		{
			System.out.println("Verified successfully");
		}
		
		//Close the browser (Do not log out)
		//driver.close();

	}

}
