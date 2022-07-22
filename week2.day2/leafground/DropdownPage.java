package week2.day2.assignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropdownPage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//initial driver setup
		WebDriverManager.chromedriver().setup();
						
		//open the page
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.leafground.com/pages/Dropdown.html");
						
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
				
		//Select by index
		System.out.println("1");
		
		WebElement drop1 = driver.findElement(By.id("dropdown1")); 
		Select selByIndex =new Select(drop1);
		
		selByIndex.selectByIndex(2);
		
		//Select using text
		System.out.println("2");
		
		WebElement drop2 = driver.findElement(By.name("dropdown2")); 
		Select selByText =new Select(drop2);
		
		selByText.selectByVisibleText("Selenium");
		
		//Select using value
		System.out.println("3");
		
		WebElement drop3 = driver.findElement(By.id("dropdown3")); 
		Select selByValue =new Select(drop3);
		
		selByValue.selectByValue("4");
		
		//number of options
		System.out.println("4");
		
		WebElement opts = driver.findElement(By.className("dropdown"));
		List<WebElement> options = opts.findElements(By.tagName("option"));
		System.out.println("The no of options are "+ (options.size()-1));
		
		driver.findElement(By.xpath("(//div[@class='example'])[5]/select")).sendKeys("UF",Keys.TAB);
		
		driver.findElement(By.xpath("(//div[@class='example'])[6]//option[4]")).click();

		
	}

}