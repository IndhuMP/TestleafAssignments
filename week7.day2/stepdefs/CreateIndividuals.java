package stepdefs;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class CreateIndividuals extends ProjectSpecificMethods{
	
	@Given("Click the Individuals option")
	public void clickIndividualsOption() throws InterruptedException {
		//Click view All and click Sales from App Launcher
		driver.findElement(By.xpath("//button[@class='slds-button']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("Individuals");
		
		driver.findElement(By.xpath("//mark[text()='Individuals']")).click();
		
		Thread.sleep(3000);
		
	}

	@Then("Click the Individuals dropdown")
	public void clickIndividualDropdown() throws InterruptedException {
	
		WebElement accountEle = driver.findElement(By.xpath("((//span[contains(text(),'Individuals')])[1]/following::a[@class='slds-button slds-button_reset'])[1]"));
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(accountEle));
		accountEle.click();
		
	}

	@And("CLick New Individual link")
	public void clickNewIndividuallink() {
		//Click on New button
		WebElement AccEle = driver.findElement(By.xpath("//span[text()='New Individual']"));
		driver.executeScript("arguments[0].click();", AccEle);
	}

	@Then("Type the first name as (.*)$")
	public void typeAccountName(String firstName) {
		//Enter 'your name' as account name
		driver.findElement(By.xpath("//input[@placeholder='First Name']")).click();
		driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys(firstName);
		
	}

	@Then("Type last name as (.*)$")
	public void typeLastName(String lastName) {
		//Enter 'your name' as account name
		driver.findElement(By.xpath("//input[@placeholder='Last Name']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys(lastName);

	}
	
	
	@Then("Click the Save")
	public void clickButtonSave() throws InterruptedException {
		
		Thread.sleep(2000);;
		//Click save and verify Account name 
		driver.findElement(By.xpath("//button[@title='Save']/span")).click();

	}
	

}
