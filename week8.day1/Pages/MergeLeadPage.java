package Pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import Base.ProjectSpecificMethods;

public class MergeLeadPage extends ProjectSpecificMethods {

	public MergeLeadPage getFromLeadValue(String firstName) throws InterruptedException {

		String primary = getDriver().getWindowHandle();

		//click on the window for from lead
		getDriver().findElement(By.xpath("//input[@id='partyIdFrom']/following::img")).click();

		//get windowhandles
		Set<String> windowHandles = getDriver().getWindowHandles();

		List<String> lstWinHandle = new ArrayList<String>(windowHandles);
		String secWindow = lstWinHandle.get(1);

		//switch to the second window
		getDriver().switchTo().window(secWindow);

		Thread.sleep(1000);
		//enter the firstname
		getDriver().findElement(By.xpath("//input[@name='firstName']")).sendKeys(firstName);

		//click find leads
		getDriver().findElement(By.xpath("//button[text()='Find Leads']")).click();

		Thread.sleep(2000);
		//click first resulting link
		getDriver().findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]")).click();

		//switch to parent
		getDriver().switchTo().window(primary);

		return this;

	}

	public MergeLeadPage getToLeadValue(String firstName) throws InterruptedException {

		String primary = getDriver().getWindowHandle();

		//click on the window for To lead
		getDriver().findElement(By.xpath("//input[@id='partyIdTo']/following::img")).click();

		//get windowhandles
		Set<String> windowHandles1 =getDriver().getWindowHandles();

		List<String> lstWinHandle1 = new ArrayList<String>(windowHandles1);
		String secWindow1 = lstWinHandle1.get(1);

		//switch to the second window
		getDriver().switchTo().window(secWindow1);

		Thread.sleep(1000);
		getDriver().findElement(By.xpath("//input[@name='firstName']")).sendKeys(firstName);

		//click find leads
		getDriver().findElement(By.xpath("//button[text()='Find Leads']")).click();

		Thread.sleep(2000);
		//click first resulting link  
		getDriver().findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[2]")).click();

		//switch to parent
		getDriver().switchTo().window(primary);

		return this;

	}

	public ViewLeadPage clickMergeButton() {

		getDriver().findElement(By.xpath("//table[@class='twoColumnForm']//a[text()='Merge']")).click();
		//get the text first from alert
		Alert alert = getDriver().switchTo().alert();
		alert.accept();

		return new ViewLeadPage();


	}

}
