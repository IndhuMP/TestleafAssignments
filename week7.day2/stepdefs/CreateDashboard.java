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

public class CreateDashboard extends ProjectSpecificMethods {
	
	@Given("Click the Dashboards option")
	public void clickDashboardsOption() throws InterruptedException {
		//Click view All and click Sales from App Launcher
		driver.findElement(By.xpath("//button[@class='slds-button']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("Dashboards");
		
		driver.findElement(By.xpath("//mark[text()='Dashboards']")).click();
		
		Thread.sleep(3000);
		
	}

	@And("CLick New Dashboard button")
	public void clickNewDashboardButton() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@title='New Dashboard']")).click();
		Thread.sleep(2000);
		
	}

	@Then("Type Dashboard name as (.*)$")
	public void typeDashboardName(String dashboardName) throws InterruptedException {
		
		//Enter 'your name' by dsahboard name
		WebElement frameEle = driver.findElement(By.xpath("//iframe[@title='dashboard']"));
		driver.switchTo().frame(frameEle);
		driver.findElement(By.xpath("//input[@id='dashboardNameInput']")).sendKeys(dashboardName);
		
	}

	@And("Click Create button")
	public void clickCreate() {

		driver.findElement(By.xpath("//button[@id='submitBtn']")).click();
		
	}
	
	@Then("Click Save")
	public void clickSave() {
		
		//Click save and verify Account name 

		WebElement frameEle = driver.findElement(By.xpath("//iframe[@title='dashboard']"));
		driver.switchTo().frame(frameEle);
		driver.findElement(By.xpath("//button[text()='Save']")).click();

	}
	
	
	@Then("Verify Dashboard is created")
	public void verifyDashboardCreated() throws InterruptedException {
		
		Thread.sleep(2000);
		String savedMessage = driver.findElement(By.xpath("//div[@class='slds-align-middle slds-hyphenate']//span")).getText();
		System.out.println(savedMessage);
		
	}


}
