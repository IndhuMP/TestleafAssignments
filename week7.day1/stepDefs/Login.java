package stepDefs;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Login extends ProjectSpecificMethods{
	
	@Given("Type the username as {string}")
	public void typeUsername(String username) {
		//find element username and send the id through driver
		driver.findElement(By.id("username")).sendKeys(username);

	}
	
	@And("Type the password as {string}")
	public void typePassword(String password) {
		//find password element and send its id through driver
		driver.findElement(By.id("password")).sendKeys(password);

	}
	
	@When("click the Login button")
	public void clickLogin() {
		//find login element and get class element
		driver.findElement(By.className("decorativeSubmit")).click();

	}
	
	@Then("Verify the home page is displayed")
	public void verifyHomePage() {
		String text = driver.findElement(By.tagName("h2")).getText();
		if(text.contains("Welcome"))
		{
			System.out.println("Home page!!");
		}
		else
		{
			System.out.println("Home page not displayed");
		}
		
	}
	
	@But("Verify the error message is displayed")
	public void verifyErrorMessage() {
		String text1 = driver.findElement(By.id("errorDiv")).getText();
		System.out.println(text1);
		
	}
	
}
