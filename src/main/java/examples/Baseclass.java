package examples;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Baseclass {

	String driverpath = "C:\\Users\\Aaludra_05\\Documents\\selenium_jenkins_demo\\Java_Basics_HandsOn_And_Jenkins\\Chromedriver";
	String url = "https://stackoverflow.com/";
	WebDriver driver;
	
	@BeforeTest
	public void test() {
		System.setProperty("webdriver.chrome.driver", driverpath);
		driver = new ChromeDriver();
		driver.get(url);
	}
	
	@Test
	public void equals() {
		String title = driver.getTitle();
		System.out.println("The title is" + title);
		String actualtitle = "Stack Overflow - Where Developers Learn, Share, & Build Careers";
		Assert.assertEquals(actualtitle, title);
	}
	
	@AfterTest
	public void teardown() {
		driver.quit();	}

}
