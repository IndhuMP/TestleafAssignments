package week4.day1;

import java.time.Duration;
import java.util.*
;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Salesforce {

	public static void main(String[] args) {
			
		WebDriverManager.chromedriver().setup();
	
		//Launch the browser
		ChromeDriver driver = new ChromeDriver();
		
		//Load the url as " https://login.salesforce.com/ "
		driver.get("https://login.salesforce.com/");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		
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
		
		Set<String> windowHandles1 = driver.getWindowHandles();
		
		List<String> lstWin1=new ArrayList<String>(windowHandles1);
		driver.switchTo().window(lstWin1.get(1));
		
		//Get the title
		String title = driver.getTitle();
		System.out.println(title);
		
		driver.close();

		//Get back to the parent window
		driver.switchTo().window(parent);
		
		//close the browser
		driver.close();
	}

}
