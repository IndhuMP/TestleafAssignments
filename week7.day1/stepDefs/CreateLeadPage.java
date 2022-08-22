package stepDefs;

import org.openqa.selenium.By;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateLeadPage extends ProjectSpecificMethods {

	@Given("Click CRMSFA Link")
	public void clickCRM() {
		
		//click crm/sfa
		driver.findElement(By.linkText("CRM/SFA")).click();
	}
	
	@And("CLick Leads Tab")
	public void clickLeadsTab() {
		
		//click leads tab
		driver.findElement(By.linkText("Leads")).click();
	}
	
	@And("Click Create Leads Link")
	public void clickLeadsLink() {

		//create a lead
		driver.findElement(By.linkText("Create Lead")).click();
	}
	
	@When("Type the company name as (.*)$")
	public void typeCompanyName(String companyName) {
		
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(companyName);
	}
	
	@And("Type the first name as (.*)$")
	public void typeFirstName(String firstName) {
		
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(firstName);		
	}
	
	@And("Type the last name as (.*)$")
	public void typeLastName(String lastName) {
		
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lastName);
	}
	
	@And("Click Create Leads Button")
	public void clickCreateLeadsButton() {
		
		driver.findElement(By.className("smallSubmit")).click();		
	}
	
	@Then("Verify the View Leads Button")
	public void verifyVIewLeads() {
		String title = driver.getTitle();
		if(title.contains("View Leads"))
		{
			System.out.println("Got it!!");
		}
		
	}
}
