package Base;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ExcelPush;

public class ProjectSpecificMethods {

	//public static ChromeDriver driver;
	private static final ThreadLocal<RemoteWebDriver> remoteWebDriver = new ThreadLocal<RemoteWebDriver>();
	public String excelFileName="";

	//setter method for driver
	public void setDriver() {
		remoteWebDriver.set(new ChromeDriver());
	}

	public RemoteWebDriver getDriver() {
		return remoteWebDriver.get();
	}


	@BeforeMethod
	public void init() {
		WebDriverManager.chromedriver().setup();
		//driver = new ChromeDriver();
		//to initialize the driver
		setDriver();
		getDriver().get("http://leaftaps.com/opentaps");
		getDriver().manage().window().maximize();
	}

	@AfterMethod
	public void closeBrowser()
	{
		getDriver().close();
	}

	@DataProvider(name="fetchData")
	public String [][] fetchdata() throws IOException{
		String[][] data = ExcelPush.readData(excelFileName);
		return data;
	}


}
