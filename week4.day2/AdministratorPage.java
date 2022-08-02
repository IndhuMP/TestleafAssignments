package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class AdministratorPage {

	public static void main(String[] args) throws InterruptedException, IOException {

		//Launch Salesforce application https://login.salesforce.com/
		WebDriverManager.chromedriver().setup();
		
		//Launch the browser
		ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        ChromeDriver driver = new ChromeDriver(options);
        
		//Load the url as " https://login.salesforce.com/ "
		driver.get("https://login.salesforce.com/");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		
		//Login with username as "ramkumar.ramaiah@testleaf.com " and password as "Password$123"
		//Enter the username as " ramkumar.ramaiah@testleaf.com "
		driver.findElement(By.id("username")).sendKeys("ramkumar.ramaiah@testleaf.com");
				
		//Enter the password as " Password$123 "
		driver.findElement(By.id("password")).sendKeys("Password$123");
				
		//click on the login button
		driver.findElement(By.id("Login")).click();
		
		//click on the learn more option in the Mobile publisher
		driver.findElement(By.xpath("//span[text()='Learn More']")).click();
				
		//Switch to the next window using Windowhandles.
		Set<String> windowHandles = driver.getWindowHandles();
				
		List<String> lstWin=new ArrayList<String>(windowHandles);
		driver.switchTo().window(lstWin.get(1));
				
		//click on the confirm button in the redirecting page
		driver.findElement(By.xpath("//button[text()='Confirm']")).click();
		
		Shadow dom=new Shadow(driver);
		
		//Click Resources 
		WebElement resources = dom.findElementByXPath("//span[text()='Resources']");
		resources.click();
		
		//mouse hover on Learning On Trailhead
		WebElement learningHover = dom.findElementByXPath("//span[text()='Learning on Trailhead']");
		
		Thread.sleep(3000);
		Actions builder = new Actions(driver);
		builder.moveToElement(learningHover).perform();
		
		//Clilck on Salesforce Certifications
		Thread.sleep(3000);
		dom.findElementByXPath("//a[text()='Salesforce Certification']").click();
		
		
		//Click on Ceritification Administrator
		driver.findElement(By.xpath("//div[text()='Administrator']")).click();
		
		//Navigate to Certification - Administrator Overview window
		WebElement scrollCert = driver.findElement(By.xpath("//div/h1[text()='What is a Salesforce Administrator?']"));
		builder.scrollToElement(scrollCert).perform();
		
		//Verify the Certifications available for Administrator Certifications should be displayed
		File source = driver.getScreenshotAs(org.openqa.selenium.OutputType.FILE);
		File dest = new File("./snap/SalesAdminCerti.png");
		FileUtils.copyFile(source, dest);
		
		driver.close();
	}

}
