package stepdefs;

import org.openqa.selenium.By;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class Login extends ProjectSpecificMethods{

	@Given("Type the username as {string}")
	public void typeUsername(String username) {
		//Enter the username as " ramkumar.ramaiah@testleaf.com "
		driver.findElement(By.id("username")).sendKeys(username);

	}

	@And("Type the password as {string}")
	public void typePassword(String password) {
		//Enter the password as " Password$123 "
		driver.findElement(By.id("password")).sendKeys(password);

	}


	@When("Click the Login button")
	public void clickLogin() {
		//find login element and get class element
		driver.findElement(By.id("Login")).click();

	}

	@And("Click the toggle button")
	public void clickToggleButton() throws InterruptedException{
		//Click on toggle menu button from the left corner
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		//Thread.sleep(2000);
	}

}


