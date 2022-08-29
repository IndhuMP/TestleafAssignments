package testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.ProjectSpecificMethods;
import Pages.LoginPage;

public class FindLeads extends ProjectSpecificMethods
{
	
	@BeforeTest
	public void setup() {
		excelFileName = "FindLead";
	}

	@Test(dataProvider="fetchData")
	public void runLogin(String username, String password, String firstName) throws InterruptedException, IOException {
		LoginPage lp = new LoginPage();
		lp.typeUsername(username)
		.typePassword(password)
		.clickLogin()
		.clickCRM()
		.clickLeadsLink()
		.clickFindLeads()
		.typefirst_Name(firstName)
		.clickFindLeadsButton()
		.verifyFindLeadsPage();
	}

}
