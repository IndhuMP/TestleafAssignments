package stepDefs;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EditLeadPage extends ProjectSpecificMethods{
	@Given("Click CRM_SFA Link")
	public void clickCRMSFA() {

		//Click crm/sfa link
		driver.findElement(By.linkText("CRM/SFA")).click();
	}

	@And("CLick the Leads Tab")
	public void clickTheLeadsTab() {

		//Click Leads link
		driver.findElement(By.linkText("Leads")).click();	
	}

	@And("Click Find Leads Link")
	public void clickFindLink() {

		//Click Find leads
		driver.findElement(By.linkText("Find Leads")).click();
	}

	@When("Type first name as (.*)$")
	public void typefirst_Name(String firstName) {

		//Enter first name
		driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys(firstName);
	}

	@And("Click the Find Leads button")
	public void clickFindLeadsButton() {

		//Click Find leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
	}

	@Then("Click on the first resulting lead")
	public void clickFirstLead() {
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement firstLead = driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-firstName']//a)[1]"));
		wait.until(ExpectedConditions.stalenessOf(firstLead));
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-firstName']//a)[1]")).click();

		//driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]")).click();
		}

	@When("Click the Edit button")
	public void clickEditButton() {

		driver.findElement(By.linkText("Edit")).click();		
	}

	@And("Change the company name as (.*)$")
	public void changeCompanyName(String companyName) {
		//Change the company name
		driver.findElement(By.id("updateLeadForm_companyName")).clear();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys(companyName);

	}

	@When("Click Update Button")
	public void clickUpdateButton() {

		//Click Update
		driver.findElement(By.xpath("//input[@value='Update']")).click();

	}

	@Then("Verify the company name changes as (.*)$")
	public void verifyChangedName(String companyName) {
		//Confirm the changed name appears
		String changed_name = driver.findElement(By.id("viewLead_companyName_sp")).getText();

		if(changed_name.contains(companyName))
		{
			System.out.println("Company name changed successfully");
		}

	}


}
