package Pages;

import org.openqa.selenium.By;

import Base.ProjectSpecificMethods;

public class MyLeadsPage extends ProjectSpecificMethods{

	public CreateLeadPage clickCreateLeadsLink() {

		//create a lead
		getDriver().findElement(By.linkText("Create Lead")).click();
		return new CreateLeadPage();
	}
	public FindLeadPage clickFindLeads() {
		
		getDriver().findElement(By.linkText("Find Leads")).click();
		return new FindLeadPage();
	}
}

