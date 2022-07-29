
package week3.day2.assignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ajio {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		
		// Step 2: Instantaite the ChromeDriver
		ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        ChromeDriver driver = new ChromeDriver(options);
		
		// Loads a new web page in the current browser window
		// Maximise the screen
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get("https://www.ajio.com/");
		
		//In the search box, type as "bags" and press enter
		driver.findElement(By.name("searchVal")).sendKeys("bags", Keys.ENTER);
		
		//driver.findElement(By.id("Men")).click();
		Thread.sleep(2000);
		
		// To the left  of the screen under " Gender" click the "Men"
		driver.findElement(By.xpath("//label[@for='Men']")).click();
		
		//Under "Category" click "Fashion Bags"
		driver.findElement(By.xpath("(//label[contains(@class,'facet-linkname facet-linkname-l1l3nestedcategory')])[2]")).click();
		
		//driver.findElement(By.xpath("//label[@for='Men - Fashion Bags']")).click();
		driver.findElement(By.xpath("//label[@for='Men - Fashion Bags']")).click();
		Thread.sleep(2000);
		
		String text = driver.findElement(By.xpath("//div[@class='length']")).getText();
		
		System.out.println("Total no.of items : " + text);
		
		//Get the list of brand of the products displayed in the page and print the list.
		System.out.println(" List of Brands");
		
		List<WebElement> brandname = driver.findElements(By.className("brand"));
		
		//get the numbwer of brandsand print the name
	    System.out.println(" Size :" + brandname.size());
		for(WebElement elements : brandname)
		{
			System.out.println(elements.getText());
		}
		
		//Get the list of names of the bags and print it
		System.out.println(" List of Bags");
		
		List<WebElement> bags = driver.findElements(By.xpath("//div[@class='nameCls']"));
		
		//get the number
		System.out.println(" Size :" + bags.size());
		//print the name
		for(WebElement elements : bags)
		{
			System.out.println(elements.getText());
		}

		

	}

}
