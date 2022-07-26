package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		/*String property = System.getProperty("webdriver.chrome.driver");
		System.out.println(property);*/
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		
		//find element username and send the id through driver
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		
		//find password element and send its id through driver
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		
		//find login element and get class element
		driver.findElement(By.className("decorativeSubmit")).click();
		
		//check if it is correct page
		//WebElement logout = driver.findElement(By.className("decorativeSubmit"));
		
		//click crm/sfa
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		//click leads tab
		driver.findElement(By.linkText("Leads")).click();
		
		//create a lead
		driver.findElement(By.linkText("Create Lead")).click();
		
		//enter company name
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("XYZ");
		
		//enter first name
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Indhumathi");
		
		//enter last name
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Mohan");
		
		//enter first name local
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("Indhu");
		
		//enter department
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("Mech");
		
		//enter description
		driver.findElement(By.id("createLeadForm_description")).sendKeys("Test case preparation");
		
		//enter email
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("indhumohan@g.com");
		
		//select state in dropdown
		WebElement drop = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		
		//create a select class
		Select select = new Select(drop);
		
		select.selectByVisibleText("New York");
		
		//click submit button
		driver.findElement(By.className("smallSubmit")).click();
		
		//get title of the page
		String title = driver.getTitle();
		
		System.out.println(title);
		
		if(title.equals("View Lead | opentaps CRM"))
		{
			System.out.println("Added successfully");
		}
		
		//click the duplicate lead button
		driver.findElement(By.linkText("Duplicate Lead")).click();
		
		//clear the company value entered before
		driver.findElement(By.id("createLeadForm_companyName")).clear();
		
		//enter another value for company		
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("ZYX");
		
		//clear the first name entered earlier
		driver.findElement(By.id("createLeadForm_firstName")).clear();
		
		//enter another value
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Indhu");
		
		//click the create lead button
		driver.findElement(By.className("smallSubmit")).click();
		
		//get title of the page
		String title1 = driver.getTitle();
		
		System.out.println(title1);
		
		//verify the page
		if(title1.equals("View Lead | opentaps CRM"))
		{
			System.out.println("Added successfully");
		}
		
		
	}

}
