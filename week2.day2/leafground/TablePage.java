package week2.day2.assignment;

import java.time.Duration;
//import java.util.*;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TablePage {

	public static void main(String[] args) {
		//initial driver setup
		WebDriverManager.chromedriver().setup();
						
		//open the page
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.leafground.com/pages/table.html");
						
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		
		//get count of columns
		List<WebElement> columns = driver.findElements(By.xpath("//tbody/tr[2]/td"));
		int cols = columns.size();
		System.out.println("There are "+cols+" columns");
		
		//get count of rows
		List<WebElement> rows = driver.findElements(By.xpath("//input[@type ='checkbox']"));
		int rowCount = rows.size();
		System.out.println("There are "+rowCount+" rows");		
		
		//Get the progress value of 'Learn to interact with Elements'
		String progressValue = driver.findElement(By.xpath("//font[text()[normalize-space()='80%']]")).getText();
		System.out.println(progressValue);
		
		//tick the vital task for the least completed progress.
		String handleExceptions = driver.findElement(By.xpath("//font[text()[normalize-space()='Handle Exceptions']]")).getText();		
		System.out.println(handleExceptions);
	}

}
