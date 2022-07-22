package week2.day2.assignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HyperlinkPage {

	public static void main(String[] args) {

		//initial driver setup
		WebDriverManager.chromedriver().setup();
				
		//open the page
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leafground.com/pages/Link.html");
				
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		
		//Go to Home Page
		System.out.println("1");
		driver.findElement(By.xpath("(//a[text()='Go to Home Page'])[1]")).click();
		driver.get("http://leafground.com/home.html");
		System.out.println("Homepage");
		driver.findElement(By.xpath("//h5[text()='HyperLink']")).click();
		
		//Find where am supposed to go without clicking me?
		System.out.println("2");
		driver.findElement(By.linkText("Find where am supposed to go without clicking me?")).click();
		driver.get("http://leafground.com/pages/Button.html");
		String title = driver.getTitle();
		if(title.equals("TestLeaf - Interact with Buttons"))
		{
			System.out.println("Opens button page when clicked!!");
		}
		driver.findElement(By.xpath("//a/img")).click();
		driver.findElement(By.xpath("//h5[text()='HyperLink']")).click();
		
		//Verify am I broken?
		System.out.println("3");
		driver.findElement(By.linkText("Verify am I broken?")).click();
		String title2 = driver.getTitle();
		if(title2.equals("404 Not Found"))
		{
			System.out.println("Verified error page successfully!!.");
		}
		driver.get("http://leafground.com/pages/Link.html");
		
		//Find the height and width
		System.out.println("4");
		driver.findElement(By.xpath("//label[contains(text(),'Interact with same link name')]/preceding-sibling::a")).click();
		String title3 = driver.getTitle();
		if(title3.equals("TestLeaf - Selenium Playground"))
		{
			System.out.println("Home Page!");
				
		}
		driver.findElement(By.xpath("//h5[text()='HyperLink']")).click();
		
		
		//How many links are available in this page?
		System.out.println("5");	
		driver.findElement(By.linkText("How many links are available in this page?")).click();
		WebElement links = driver.findElement(By.xpath("//section[@class='innerblock']"));
		List<WebElement> linksList = links.findElements(By.tagName("a"));
		System.out.println("The no of Links are "+ linksList.size());
		
		
		

	}

}
