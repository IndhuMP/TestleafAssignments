package week4.day1;

import java.time.Duration;
import java.util.*;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) {

		//Launch URL "http://leaftaps.com/opentaps/control/login"
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		
		//find element username and send the id through driver
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		
		//find password element and send its id through driver
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		
		//find login element and get class element
		driver.findElement(By.className("decorativeSubmit")).click();
		
		//check if it is correct page
		//WebElement logout = driver.findElement(By.className("decorativeSubmit"));
		
		//click crm/sfa
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		//Click on contacts Button
		driver.findElement(By.linkText("Contacts")).click();
		
		//Click on Merge Contacts using Xpath Locator
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		
		String parent = driver.getWindowHandle();
		
		//Click on Widget of From Contact
		driver.findElement(By.xpath("//input[@id='partyIdFrom']/following::img")).click();
		
		//get the handles of the pages in the broser
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> lstWinHandle = new ArrayList<String>(windowHandles);
		
		String secWindow = lstWinHandle.get(1);
		
		//switch to the newly opened tab
		driver.switchTo().window(secWindow);
		
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("vidya");
		driver.findElement(By.xpath("//button[text()='Find Contacts']")).click();
		
		//Click on First Resulting Contact
		driver.findElement(By.xpath("//a[@class='linktext']")).click();
		
		//switch to the parent tab
		driver.switchTo().window(parent);				
		
		//Click on Widget of To Contact
		driver.findElement(By.xpath("//input[@id='partyIdTo']/following::img")).click();
		
		//get the handles of the pages in the browser
		Set<String> windowHandles1 = driver.getWindowHandles();
		List<String> listWinHandle = new ArrayList<String>(windowHandles1);
				
		String secWindow1 = listWinHandle.get(1);	
				
		//switch to the newly opened tab
		driver.switchTo().window(secWindow1);
				
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("vidya");
		driver.findElement(By.xpath("//button[text()='Find Contacts']")).click();
				
		//Click on second Resulting Contact
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a)[3]")).click();
		
		driver.switchTo().window(parent);			
				
		//Click on Merge button using Xpath Locator
		driver.findElement(By.xpath("//a[text()='Merge']")).click();
		
		//Accept the Alert
		Alert alert = driver.switchTo().alert();
		
		alert.accept();
		
		//Verify the title of the page
		String title = driver.getTitle();
		System.out.println(title);
	}

}
