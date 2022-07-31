package week4.day1;

import java.time.Duration;
import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowPage {

	public static void main(String[] args) throws InterruptedException {
		
		//initial driver setup
				WebDriverManager.chromedriver().setup();
							
				//open the page
				ChromeDriver driver=new ChromeDriver();
				driver.get("http://www.leafground.com/pages/Window.html");
							
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				driver.manage().window().maximize();
				
				//get the window handle of the parent page
				String parent = driver.getWindowHandle();
				
				Thread.sleep(3000);
				//click the home button
				driver.findElement(By.xpath("//button[@id='home']")).click();
				
				//get the window handles of all the pages
				Set<String> windowHandles = driver.getWindowHandles();
				List<String> lstWin = new ArrayList<String>(windowHandles);
				
				String secWindow = lstWin.get(1);
				
				//switch to second handle
				driver.switchTo().window(secWindow);
				
				//close the window
				driver.close();
				
				//get to the window tab
				driver.switchTo().window(parent);
				
				driver.findElement(By.xpath("//button[text()='Open Multiple Windows']")).click();
				
				//get the window handles of all the pages
				Set<String> winHandles = driver.getWindowHandles();
				List<String> lstWindow = new ArrayList<String>(winHandles);
				
				System.out.println(lstWindow.size());
				
				for(int i=1; i<lstWindow.size(); i++)
				{
					driver.switchTo().window(lstWindow.get(i));
					driver.close();
				}
				
				//get to the window tab
				driver.switchTo().window(parent);
				
				//click do nont close button
				driver.findElement(By.xpath("//button[text()='Do not close me ']")).click();
				
				Set<String> winHandles1 = driver.getWindowHandles();
				List<String> lstWindow1 = new ArrayList<String>(winHandles1);
				
				for(int i=1; i<lstWindow1.size(); i++)
				{
					driver.switchTo().window(lstWindow1.get(i));
					driver.close();
				}
						
				//get to the window tab
				driver.switchTo().window(parent);
				
				System.out.println("do not close me done");
				
				driver.findElement(By.xpath("//button[text()='Wait for 5 seconds']")).click();
				
				Thread.sleep(5000);
				
				System.out.println("Wait done!");
				driver.quit();
					

	}

}
