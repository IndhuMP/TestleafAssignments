package week2.day2.assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditPage {

	public static void main(String[] args) {
		
		//initial driver setup
		WebDriverManager.chromedriver().setup();
		
		//open the page
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leafground.com/pages/Edit.html");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		
		//enter email
		driver.findElement(By.xpath("//label[text()='Enter your email address']/following-sibling::input")).sendKeys("indhu@gmail.com");
		
		//append text
		driver.findElement(By.xpath("//label[text()='Append a text and press keyboard tab']/following-sibling::input")).sendKeys("Additional text", Keys.TAB);
		
		//get default value
		String value = driver.findElement(By.xpath("//label[text()='Get default text entered']/following-sibling::input")).getAttribute("value");
		System.out.println(value);
		
		//Clear the text
		driver.findElement(By.xpath("//label[text()='Clear the text']/following-sibling::input")).clear();
		
		//confirm field is disabled
		boolean check_enable = driver.findElement(By.xpath("//label[text()='Confirm that edit field is disabled']/following-sibling::input")).isEnabled();
		System.out.println(check_enable);
		
		
		
	}
}
