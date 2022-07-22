package week2.day2.assignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckboxPage {

	public static void main(String[] args) {
		
		//initial driver setup
		WebDriverManager.chromedriver().setup();
					
		//open the page
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.leafground.com/pages/checkbox.html");
					
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		
		//Select the languages that you know?
		System.out.println("1");
		driver.findElement(By.xpath("(//div[@class='example'])[1]/input[1]")).click();
		driver.findElement(By.xpath("(//div[@class='example'])[1]/input[2]")).click();
		System.out.println("Selected known languages");

		//Confirm Selenium is checked
		System.out.println("2");
		boolean selected = driver.findElement(By.xpath("//label[text()='Confirm Selenium is checked']/following::input")).isSelected();		
		if(selected)
		{
				System.out.println("Selenium is checked");
		}
		else 
		{
			System.out.println("Selenium not checked");
		}
		
		
		//DeSelect only checked
		System.out.println("3");
		boolean sel = driver.findElement(By.xpath("(//label[text()='DeSelect only checked']/following::input)[2]")).isSelected();
		
		if(sel)
		{
			driver.findElement(By.xpath("(//label[text()='DeSelect only checked']/following::input)[2]")).click();
			System.out.println("Deselected the previously selected");
		}
		
		//Select all below checkboxes
		System.out.println("4");
		//driver.findElement(By.xpath("//label[text()='Select all below checkboxes ']/following::input")).click();
		WebElement checks = driver.findElement(By.xpath("(//div[@class='example'])[4]"));
		List<WebElement> checkBoxes = checks.findElements(By.tagName("input"));
		for(WebElement check:checkBoxes)
		{
			check.click();
		}
		System.out.println("All checkboxes are selected");
		
				


	}

}
