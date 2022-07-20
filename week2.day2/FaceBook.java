package week2.day2.assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FaceBook {

	public static void main(String[] args) {

		//Step 1: Download and set the path 
		WebDriverManager.chromedriver().setup();
		
		// Step 2: Launch the chromebrowser
		ChromeDriver driver = new ChromeDriver();
		
		// Step 3: Load the URL https://en-gb.facebook.com/
		driver.get(" https://en-gb.facebook.com/");
		
		// Step 5: Add implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		// Step 4: Maximise the window
		driver.manage().window().maximize();		
		
		// Step 6: Click on Create New Account button
		driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
		
		// Step 7: Enter the first name
		driver.findElement(By.xpath("//input[@placeholder='First name']")).sendKeys("Indhu");
		
		// Step 8: Enter the last name
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Mohan");
		
		// Step 9: Enter the mobile number
		driver.findElement(By.xpath("//div[text()='Mobile number or email address']/following-sibling::input")).sendKeys("1000000000");
		
		// Step 10: Enterthe password
		driver.findElement(By.xpath("//input[@data-type='password']")).sendKeys("XYZ123xyz");
		
		// Step 11: Handle all the three drop downs
		//day
		WebElement day = driver.findElement(By.id("day"));
		//create a select class
		Select sel_day = new Select(day);
		sel_day.selectByVisibleText("18");
		
		
		//month
		WebElement month = driver.findElement(By.id("month"));		
		//create a select class
		Select sel_month = new Select(month);
		sel_month.selectByValue("11");
			
		
		//year
		WebElement year = driver.findElement(By.id("year"));		
		//create a select class
		Select sel_year = new Select(year);
		sel_year.selectByVisibleText("1990");
		
		// Step 12: Select the radio button "Female" 
		driver.findElement(By.xpath("//label[text()='Female']/following-sibling::input")).click();
		
		             
	}

}
