package marathon;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

//import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BookMyShow {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        ChromeDriver driver = new ChromeDriver(options);
		
		//ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://in.bookmyshow.com/");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.manage().window().maximize();
		
		//click hyderabad
		driver.findElement(By.xpath("//span[text()='Hyderabad']")).click();
		
		//Confirm the URL has got loaded with Hyderabad
		String currentUrl = driver.getCurrentUrl();
		
		//String city = driver.findElement(By.xpath("//div[@class='sc-kaNhvL euaMLw']/span")).getText();
		if(currentUrl.contains("hyderabad"))
		{
			System.out.println("Verified Successfully.");
		}
		driver.findElement(By.xpath("//span[@id='4']")).click();
		
		//Search for your favorite movie
		driver.findElement(By.xpath("//input[@class='sc-jvEmr elijMA']")).sendKeys("Thank You");
		driver.findElement(By.xpath("//div[@class='sc-fQkuQJ hqIzUw']")).click();
		
		//Click Book Tickets
		driver.findElement(By.xpath("(//span[text()='Book tickets'])[1]")).click();
		
		//Print the name of the theater displayed first
		String theatreName= driver.findElement(By.xpath("//a[@class='__venue-name']")).getText();
		System.out.println(theatreName);
		
		//click on info of theatre
		driver.findElement(By.xpath("//img[@class='venue-info-icon lazy']")).click();
		
		//check if parking there
		boolean parkingFacility = driver.findElement(By.xpath("(//img[@class='lazy'])[2]")).isDisplayed();
		if(parkingFacility)
		{
			System.out.println("Parking available");
		}
		
		//close the theatre popup
		driver.findElement(By.xpath("//div[@class='cross-container']")).click();
		
		WebElement available = driver.findElement(By.xpath("(//div[@class='showtime-pill-container'])[1]/a/div/div"));
		String color=available.getCssValue("color");
		System.out.println(color);
		
		String color_check="rgba(74, 189, 93, 1)";
		
		if(color.equals(color_check))		
		{
			
		//Click on the first green (available) timing
		driver.findElement(By.xpath("(//div[@class='showtime-pill-container'])[1]/a")).click();
		
		//click 1 seat 
		driver.findElement(By.id("pop_1")).click();
		
		//click Select seats
		driver.findElement(By.id("proceed-Qty")).click();
		
		//click any seat
		driver.findElement(By.xpath("(//a[@class='_available'])[1]")).click();
		
		//click pay
		driver.findElement(By.xpath("//a[@id='btmcntbook']")).click();
		
		Thread.sleep(3000);
		//print subtotal
		String rs = driver.findElement(By.id("subTT")).getText();
		System.out.println(rs);
		

		File source = driver.getScreenshotAs(org.openqa.selenium.OutputType.FILE);
		File dest = new File("./snap/snap.png");
		FileUtils.copyFile(source, dest);
		
		driver.close();
		
		}

	}

}
