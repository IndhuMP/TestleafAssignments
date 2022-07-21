package week2.day2.assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ButtonPage {

	public static void main(String[] args) {

		//initial driver setup
		WebDriverManager.chromedriver().setup();
				
		//open the page
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leafground.com/pages/Button.html");
				
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		
		//Click button to travel home page
		driver.findElement(By.xpath("//button[@id='home']")).click();
		driver.get("http://leafground.com/pages");
		
		driver.findElement(By.xpath("//h5[text()='Button']")).click();
		
		//Find position of button (x,y)
		WebElement pos = driver.findElement(By.id("position"));
		System.out.println(pos.getLocation());
		
		//Find button color
		WebElement color = driver.findElement(By.xpath("//h5[text()='Button']"));
		System.out.println(color.getCssValue("color"));
		
		//Find the height and width
		WebElement ele_size = driver.findElement(By.xpath("//button[@id='size']"));
		System.out.println(ele_size.getSize());

	}

}
