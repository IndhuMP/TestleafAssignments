package Pages;

import org.openqa.selenium.By;

import Base.ProjectSpecificMethods;

public class DuplicateLeadPage extends ProjectSpecificMethods {

	public DuplicateLeadPage enterCompanyName(String compName)
	{
		//clear the company value entered before
		getDriver().findElement(By.id("createLeadForm_companyName")).clear();
		//enter another value for company		
		getDriver().findElement(By.id("createLeadForm_companyName")).sendKeys(compName);
		return this;

	}

	public DuplicateLeadPage enterFirstName(String firstName) {
		//clear the first name entered earlier
		getDriver().findElement(By.id("createLeadForm_firstName")).clear();

		//enter another value
		getDriver().findElement(By.id("createLeadForm_firstName")).sendKeys(firstName);
		return this;

	}

	public ViewLeadPage clickCreateLeadButton() {
		//click the create lead button
		getDriver().findElement(By.className("smallSubmit")).click();
		return new ViewLeadPage();
	}


}
