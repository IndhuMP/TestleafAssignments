package week2.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonFindElements {

	public static void main(String[] args) {


		//Launch the browser
		WebDriverManager.chromedriver().setup();
				
		ChromeDriver driver = new ChromeDriver();
				
		//Load https://www.amazon.in/
		driver.get("https://www.amazon.in/");
				
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				
		driver.manage().window().maximize();
				
		//type Bags
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("USI punching bag", Keys.ENTER);
				
		//check 'Eligible for Pay On Delivery' checkbox
		driver.findElement(By.xpath("//span[contains(text(),'Eligible for Pay On Delivery')]/preceding-sibling::div//i")).click();
			
		//find all the bag names and store it in a list
		List<WebElement> bagNames = driver.findElements(By.xpath("//span[@class='a-size-base-plus a-color-base a-text-normal']"));
		
		System.out.println(bagNames.get(0));
		//print the size
		int count = bagNames.size();
		System.out.println("there are "+count+" bags in this category.");
		
		//Iterate it over an array
		//Print all the names
		for(WebElement eachBag:bagNames)
		{
			System.out.println(eachBag.getText());
		}
					
		//Close the browser

	}

}
