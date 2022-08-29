package Pages;

import org.openqa.selenium.By;
import org.testng.Assert;

import Base.ProjectSpecificMethods;

public class HomePage extends ProjectSpecificMethods{

	public MyHomePage clickCRM() {

		//click crm/sfa
		getDriver().findElement(By.linkText("CRM/SFA")).click();
		return new MyHomePage();
	}

}
