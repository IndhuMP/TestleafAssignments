package Pages;

import org.openqa.selenium.By;
import org.testng.Assert;

import Base.ProjectSpecificMethods;

public class ViewLeadPage extends ProjectSpecificMethods{

	public ViewLeadPage verifyViewLead() {
		String title=getDriver().getTitle();
		String expectedTitle = "View Lead | opentaps CRM";

		Assert.assertEquals(expectedTitle, title);

		return this;

	}

	public EditLeadPage clickEditButton() {

		getDriver().findElement(By.linkText("Edit")).click();	
		return new EditLeadPage();
	}

	public DuplicateLeadPage clickDuplicateButton() {
		
		//click the duplicate lead button
		getDriver().findElement(By.linkText("Duplicate Lead")).click();
		return new DuplicateLeadPage();

	}
}
