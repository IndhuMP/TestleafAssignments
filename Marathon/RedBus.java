package marathon;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RedBus {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		
		//Load https://www.amazon.in/
		driver.get("https://www.redbus.in/");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.manage().window().maximize();
		
		//type chennai in from box
		driver.findElement(By.id("src")).sendKeys("Chennai");
		driver.findElement(By.xpath("//li[@data-id='123']/i")).click();
		
		//type bangalore in to box
		driver.findElement(By.id("dest")).sendKeys("Bangalore");
		driver.findElement(By.xpath("//li[@data-id='122']/i")).click();
		
		
		//enter tomorrow
		driver.findElement(By.xpath("//input[@id='onward_cal']")).click();
		driver.findElement(By.xpath("//td[@class='current day']/following-sibling::td")).click();
		driver.findElement(By.xpath("//button[text()='Search Buses']")).click();
		
		//get the number of buses
		//String bus = driver.findElement(By.xpath("//div[@class='w-16 fl m-top-22']/div")).getText();
		String bus = driver.findElement(By.xpath("//span[contains(@class,'w-60 d-block')]")).getText();
		String wrods[]=bus.split(" ");
		System.out.println(wrods[0]);
		
		//choose sleeper
		driver.findElement(By.xpath("//label[@for='bt_SLEEPER']")).click();
		
		//choose second element
		String travel = driver.findElement(By.xpath("(//div[@class='travels lh-24 f-bold d-color'])[2]")).getText();
		System.out.println(travel);
		
		//click view seats
		driver.findElement(By.xpath("(//div[text()='View Seats'])[2]")).click();
		
		File source = driver.getScreenshotAs(org.openqa.selenium.OutputType.FILE);
		File dest = new File("./snap/snap1.png");
		FileUtils.copyFile(source, dest);
		
		driver.close();
		
	}

}
