package Pages;

import org.openqa.selenium.By;

import Base.ProjectSpecificMethods;

public class EditLeadPage extends ProjectSpecificMethods {

	public EditLeadPage changeCompanyName(String companyName) {
		//Change the company name
		getDriver().findElement(By.id("updateLeadForm_companyName")).clear();
		getDriver().findElement(By.id("updateLeadForm_companyName")).sendKeys(companyName);
		return this;

	}
	
	public ViewLeadPage clickUpdateButton() {

		//Click Update
		getDriver().findElement(By.xpath("//input[@value='Update']")).click();
		return new ViewLeadPage();
	}
	
}
