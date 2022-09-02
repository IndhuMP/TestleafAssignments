package stepdefs;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class CreateOppurWithoutMandatory extends ProjectSpecificMethods {


	@And("Select Close date")
	public void selectClose() {

		driver.findElement(By.xpath("//input[@name='CloseDate']")).click();
		driver.findElement(By.xpath("//td[@data-value='2022-09-02']/span")).click();


	}
	
	
	@Then("Verify mandatory alert")
	public void verifyMandatoryAlert() throws InterruptedException {

		Thread.sleep(2000);
		List<WebElement> labels = driver.findElements(By.xpath("//div[@class='fieldLevelErrors']//li/a"));
		String label1 = labels.get(0).getText();
		String label2 = labels.get(1).getText();
		//String label1 = driver.findElement(By.xpath("//div[text()='Complete this field.'])[1]/preceding::label[1]")).getText();
		//String label2 = driver.findElement(By.xpath("//div[text()='Complete this field.'])[2]/preceding::label[1]")).getText();
		
		System.out.println("Mandatory alert generated for "+label1+" and "+label2);
	}


}
