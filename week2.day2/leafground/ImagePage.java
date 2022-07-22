package week2.day2.assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImagePage {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver=new ChromeDriver();

		driver.get("http://www.leafground.com/pages/Image.html");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Click button to travel home page
				//System.out.println("1");
				driver.findElement(By.xpath("//button[@id='home']")).click();
				driver.get("http://leafground.com/home.html");
				
				driver.findElement(By.xpath("//h5[text()='Button']")).click();
				
				//Find position of button (x,y)
				//System.out.println("2");
				WebElement pos = driver.findElement(By.id("position"));
				System.out.println(pos.getLocation());
				
				//Find button color
				//System.out.println("3");
				WebElement color = driver.findElement(By.xpath("//button[@id='color']"));
				System.out.println(color.getCssValue("color"));
				
				//Find the height and width
				//System.out.println("4");
				WebElement ele_size = driver.findElement(By.xpath("//button[@id='size']"));
				System.out.println(ele_size.getSize());
				
	}

}
