package marathon;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
//import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		//Launch Chrome
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		
		//Load https://www.amazon.in/
		driver.get("https://www.amazon.in/");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.manage().window().maximize();
		
		//type Bags
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Bags");
		
		//click bags for boys
		driver.findElement(By.xpath("//div[@aria-label='bags for boys']")).click();
		
		//Print the total number of results (like 30000)
		
		String result_value = driver.findElement(By.xpath("(//span[@class='a-color-state a-text-bold']/preceding-sibling::span)[1]")).getText();		
		//System.out.println(result_value+" bags for Boys");
		
		String total=result_value.replaceAll("([^0-9]+)","");
		System.out.println(total.substring(3));
		
		//Thread.sleep(3000);
		
		//Select the first 2 brands in the left menu (like American Tourister, Generic)
		driver.findElement(By.xpath("//span[text()='American Tourister']/preceding-sibling::div//i[@class='a-icon a-icon-checkbox']")).click();
		
		Thread.sleep(3000);
		//driver.findElement(By.xpath("//li[@aria-label='Generic']")).click();
		driver.findElement(By.xpath("//span[text()='Generic']/preceding-sibling::div//i[@class='a-icon a-icon-checkbox']")).click();
		
		//Thread.sleep(3000);
		//get the result after brand check
		String new_res = driver.findElement(By.xpath("(//span[@class='a-color-state a-text-bold']/preceding-sibling::span)[1]")).getText();		
		//System.out.println(result_value+" bags for Boys");
		
		String new_tot=new_res.replaceAll("([^0-9]+)","");
		System.out.println(new_tot.substring(3));
		
		int all = Integer.parseInt(total.substring(3));
		int selected = Integer.parseInt(new_tot.substring(3));
		
		if(selected < all)
		{
			System.out.println("Reduced results produced.");
		}
		
		//click new arrivals
		driver.findElement(By.xpath("//span[@class='a-button-text a-declarative']")).click();
		
		driver.findElement(By.linkText("Newest Arrivals")).click();
		
		//get the name of the first resulting lead
		String name = driver.findElement(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[1]")).getText();
		System.out.println("Name of the first bag" +name);
		
		//driver.findElement(By.xpath("")).getText();
		//String price = driver.findElement(By.xpath("(//span[contains(@class,'a-size-base-plus a-color-base')])[2]")).getText();
		String  price= driver.findElement(By.xpath("//span[text()='399']")).getText();
		System.out.println("Price of the first bag "+price);
		
		//take a deal of the day
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).clear();
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Bags");
		driver.findElement(By.xpath("//div[@aria-label='bags for travelling']")).click();
		
		WebElement deal_color = driver.findElement(By.xpath("(//span[@class='a-badge-text'])[1]"));
		String color=deal_color.getCssValue("color");
		
		System.out.println(color);
		
		//get price of deal 
		String price_after = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]")).getText();
		System.out.println(price_after);
		
		driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]")).click();
				
		//String price_before = driver.findElement(By.xpath("(//span[@class='a-price a-text-price a-size-medium apexPriceToPay')[1]/span")).getText();
		
		String price_before = driver.findElement(By.xpath("//div[@id='corePrice_desktop']/div[1]/table[1]/tbody[1]/tr[2]/td[2]/span[1]/span[2]")).getText();
		System.out.println(price_before);
		String new_price=price_before.replaceAll("([^0-9]+)","");
		//System.out.println(new_price);
		int x=new_price.length()-2;
		String h=(new_price.substring(0, x));
		
		if(price_after.equals(h))
		{
			System.out.println("Price matches");
		}
		
		File source = driver.getScreenshotAs(org.openqa.selenium.OutputType.FILE);
		File dest = new File("./snap.png");
		FileUtils.copyFile(source, dest);
		
		driver.close();
		
	}

}
