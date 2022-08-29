package Pages;

import java.io.IOException;

import org.openqa.selenium.By;

import Base.ProjectSpecificMethods;

public class LoginPage extends ProjectSpecificMethods{
	
	public LoginPage typeUsername(String username){
		
		//find element username and send the id through driver
		getDriver().findElement(By.id("username")).sendKeys(username);
		return this;
	}
		
	
	public LoginPage typePassword(String password) {
		//find password element and send its id through driver
		getDriver().findElement(By.id("password")).sendKeys(password);
		return this;
	}
	
	public HomePage clickLogin() {
		//find login element and get class element
		getDriver().findElement(By.className("decorativeSubmit")).click();
		return new HomePage();
	}
	
	
}
