package testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.ProjectSpecificMethods;
import Pages.LoginPage;

public class CreateLead extends ProjectSpecificMethods{
	
	@BeforeTest
	public void setup() {
		excelFileName = "CreateLead";
		
	}

	@Test(dataProvider="fetchData")
	public void runLogin(String username, String password, String compName, String firstName, String lastName) throws IOException {
		LoginPage lp = new LoginPage();
		lp.typeUsername(username)
		.typePassword(password)
		.clickLogin()
		.clickCRM()
		.clickLeadsLink()
		.clickCreateLeadsLink()
		.typeCompanyName(compName)
		.typeFirstName(firstName)
		.typeLastName(lastName)
		.clickCreateLeadsButton()
		.verifyViewLead();
		
		
	}
}
