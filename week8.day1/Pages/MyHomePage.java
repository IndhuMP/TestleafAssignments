package Pages;

import org.openqa.selenium.By;

import Base.ProjectSpecificMethods;

public class MyHomePage extends ProjectSpecificMethods{

	public MyLeadsPage clickLeadsLink() {

		//create a lead
		getDriver().findElement(By.linkText("Create Lead")).click();
		return new MyLeadsPage();
	}

}
