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

public class ArchitectPage {

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
		
		//get the window handle of initial page
		String parent = driver.getWindowHandle();
		
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
		
		
		//Choose Your Role as Salesforce Architect
		driver.findElement(By.xpath("//div[text()='Architect']")).click();
		
		//Get the Text(Summary) of Salesforce Architect 
		String text = driver.findElement(By.xpath("//div/h1[text()='Salesforce Architect']/following::div")).getText();
		System.out.println("TextSummary\n"+text);
		
		//Get the List of Salesforce Architect Certifications Available
		List<WebElement> nameCerti = driver.findElements(By.xpath("//div[@class='credentials-card_title']"));
		
		for(WebElement name:nameCerti)
		{
			System.out.println(name.getText());
		}
		
		//Click on Application Architect 
		driver.findElement(By.linkText("Application Architect")).click();
		
		//Get the List of Certifications available
		List<WebElement> archiCerti = driver.findElements(By.xpath("//div[@class='credentials-card_title']"));
		
		System.out.println("Architect certifications--------\n");
		for(int i=0; i<4; i++)
		{
			System.out.println(archiCerti.get(i).getText());
		}
		
		driver.quit();
		
	}

}
