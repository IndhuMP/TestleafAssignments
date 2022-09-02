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

public class CreateAccounts extends ProjectSpecificMethods {
	
	@Given("Click the Accounts option")
	public void clickAccountsOption() throws InterruptedException {
		
	
		//Click view All and click Sales from App Launcher
		driver.findElement(By.xpath("//button[@class='slds-button']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("Accounts");
		
		driver.findElement(By.xpath("//mark[text()='Accounts']")).click();
			}

	@Then("Click the Accounts dropdown")
	public void clickAccountDropdown() throws InterruptedException {
	

		Thread.sleep(3000);
		WebElement accountEle = driver.findElement(By.xpath("((//span[contains(text(),'Accounts')])[1]/following::a[@class='slds-button slds-button_reset'])[1]"));
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(accountEle));
		accountEle.click();
		
	}

	@And("CLick New Account link")
	public void clickNewAccountlink() throws InterruptedException {
		
		//Click on New button
		WebElement AccEle = driver.findElement(By.xpath("//span[text()='New Account']"));
		driver.executeScript("arguments[0].click();", AccEle);
		Thread.sleep(2000);
	}

	@Then("Type account name as (.*)$")
	public void typeAccountName(String firstName) throws InterruptedException {
		
		//Enter 'your name' as account name
		driver.findElement(By.xpath("//input[@name='Name']")).click();
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys(firstName);

	}

	@And("Select Employee")
	public void selectEmployee() {

		//Select Ownership as Public 
		WebElement ownerEle = driver.findElement(By.xpath("//label[text()='Employees']"));
		builder.scrollToElement(ownerEle).perform();

	}

	@And("Select ownership as public")
	public void selectOwnership() {
		driver.findElement(By.xpath("//label[text()='Ownership']/following::span")).click();
		driver.findElement(By.xpath("//span[@title='Public']")).click();
	}
	@Then("Click Save button")
	public void clickSaveButton() {
		//Click save and verify Account name 
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();

	}
	@Then("Verify Account created for (.*)$")
	public void verifyAccountCreated(String firstName) throws InterruptedException {
		
		Thread.sleep(2000);
		String name = driver.findElement(By.xpath("//lightning-formatted-text[@class='custom-truncate']")).getText();
		Assert.assertEquals(firstName, name);
		
	}


}
