package testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.ProjectSpecificMethods;
import Pages.LoginPage;

public class verifyLogin extends ProjectSpecificMethods{

	
	@BeforeTest
	public void setup() {
		excelFileName = "Login";
		
	}
	
	@Test(dataProvider="fetchData")
	public void runLogin(String username, String password) throws IOException {
		LoginPage lp = new LoginPage();
		
		lp.typeUsername(username)
		.typePassword(password)
		.clickLogin();
		
		
	}
}
