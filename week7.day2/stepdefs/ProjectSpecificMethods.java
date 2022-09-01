package stepdefs;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ProjectSpecificMethods extends AbstractTestNGCucumberTests{


	public static ChromeDriver driver;
	public static ChromeOptions options;
	public static WebDriverWait wait;
	public static Actions builder;

	@BeforeMethod
	public void init() {
		WebDriverManager.chromedriver().setup();		

		//Launch the browser
		options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);

		builder = new Actions(driver);

		//Load the url as " https://login.salesforce.com/ "
		driver.get("https://login.salesforce.com/");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
	}



	@AfterMethod
	public void teardown() { 

		driver.close(); 
	}



}
