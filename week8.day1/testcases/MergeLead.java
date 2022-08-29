package testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.ProjectSpecificMethods;
import Pages.LoginPage;

public class MergeLead extends ProjectSpecificMethods{

	@BeforeTest
	public void setup() {
		excelFileName = "MergeLead";

	}

	@Test(dataProvider="fetchData")
	public void runLogin(String username, String password, String firstName) throws IOException, InterruptedException {
		LoginPage lp = new LoginPage();
		lp.typeUsername(username)
		.typePassword(password)
		.clickLogin()
		.clickCRM()
		.clickLeadsLink()
		.clickMergeLeadButton()
		.getFromLeadValue(firstName)
		.getToLeadValue(firstName)
		.clickMergeButton()
		.verifyViewLead();
	}
}
