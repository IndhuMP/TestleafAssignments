package stepdefs;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ProjectMethods {

	public static ChromeDriver driver;

	@BeforeMethod
	public void init() {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		//Load zoomcar bangalore
		driver.get("https://www.zoomcar.com/in/bangalore");

		//implicit wait incase of slow
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.manage().window().maximize();

	}



	@AfterMethod
	public void teardown() { 

		driver.close(); 
	}


}
