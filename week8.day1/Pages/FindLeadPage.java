package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Base.ProjectSpecificMethods;

public class FindLeadPage extends ProjectSpecificMethods {

	public FindLeadPage typefirst_Name(String firstName) throws InterruptedException {

		//Enter first name
		Thread.sleep(2000);
		getDriver().findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys(firstName);
		return this;
	}

	public FindLeadPage clickFindLeadsButton() {

		//Click Find leads button
		getDriver().findElement(By.xpath("//button[text()='Find Leads']")).click();
		return this;
	}

	public ViewLeadPage clickFirstLead() throws InterruptedException {

		Thread.sleep(2000);
		getDriver().findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-firstName']//a)[1]")).click();
		return new ViewLeadPage();

	}
	
	public FindLeadPage verifyFindLeadsPage()
	{
		String expTitle = "Find Leads | opentaps CRM";
		String title = getDriver().getTitle();
		Assert.assertEquals(title, expTitle);
		return this;
	}
	}
