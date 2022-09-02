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

public class CreateOppurtunity extends ProjectSpecificMethods {

	@Given("Click the Sales option")
	public void clickSalesOption() throws InterruptedException {

		//Click view All and click Sales from App Launcher
		driver.findElement(By.xpath("//button[@class='slds-button']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("Sales");

		driver.findElement(By.xpath("(//mark[text()='Sales'])[3]")).click();
		Thread.sleep(3000);

	}

	@Then("Click the Opportunities dropdown")
	public void clickAccountDropdown() throws InterruptedException {

		WebElement opporEle = driver.findElement(By.xpath("((//span[contains(text(),'Opportunities')])[1]/following::a[@class='slds-button slds-button_reset'])[1]"));
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(opporEle));
		opporEle.click();

	}

	@And("CLick New Opportunity link")
	public void clickOpportunitylink() {
		//Click on New button
		WebElement AccEle = driver.findElement(By.xpath("//span[text()='New Opportunity']"));
		driver.executeScript("arguments[0].click();", AccEle);
	}

	@Then("Type name as (.*)$")
	public void typeOpportunityName(String opportunityName) {

		WebElement nameEle = driver.findElement(By.xpath("//input[@name='Name']"));
		nameEle.sendKeys(opportunityName);
		String opporEle = nameEle.getText();
		System.out.println(opporEle);

	}

	@And("Select the Close date")
	public void selectClosedate() {

		driver.findElement(By.xpath("//input[@name='CloseDate']")).click();
		driver.findElement(By.xpath("//button[@name='today']")).click();


	}

	@And("Select Stage option")
	public void selectStage() {
		driver.findElement(By.xpath("//label[text()='Stage']/following::button")).click();
		driver.findElement(By.xpath("//span[@title='Needs Analysis']")).click();
	}
	
	
	@Then("Verify opportunity created")
	public void verifyOpportunityCreated() throws InterruptedException {

		Thread.sleep(2000);
		String createdText = driver.findElement(By.xpath("//lightning-formatted-text[@slot='primaryField']")).getText();
		System.out.println(createdText);
	}


}
