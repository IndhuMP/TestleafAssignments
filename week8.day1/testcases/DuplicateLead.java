package testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.ProjectSpecificMethods;
import Pages.LoginPage;

public class DuplicateLead extends ProjectSpecificMethods {
	
	@BeforeTest
	public void setup() {
		excelFileName = "DuplicateLead";
	}

	@Test(dataProvider="fetchData")
	public void runLogin(String username, String password, String firstName, String compName) throws InterruptedException, IOException {
		LoginPage lp = new LoginPage();
		lp.typeUsername(username)
		.typePassword(password)
		.clickLogin()
		.clickCRM()
		.clickLeadsLink()
		.clickFindLeads()
		.typefirst_Name(firstName)
		.clickFindLeadsButton()
		.clickFirstLead()
		.clickDuplicateButton()
		.enterCompanyName(compName)
		.enterFirstName(firstName)
		.clickCreateLeadButton()
		.verifyViewLead();

}
}
