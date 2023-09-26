package testCases;

//import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;


public class Baseclass1 {
	
	String Path = "C:\\Users\\Aaludra_05\\Downloads\\Demoproject (1)\\Demoproject\\Chromedriver\\chromedriver.exe";
	String url = "https://www.saucedemo.com/?ref=hackernoon.com";
	public static WebDriver driver;
	
	
	@BeforeSuite
	public void getin() {
		System.setProperty("webdriver.chrome.driver", Path);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
	}
	
	@AfterSuite
	public void teardown() {
		driver.quit();
	}

}
