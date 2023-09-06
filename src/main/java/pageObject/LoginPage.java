package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	@FindBy(id ="user-name")
	public static WebElement username;
	
	@FindBy(id ="password")
	public static WebElement password1;
	
	@FindBy(id = "login-button")
	public static WebElement button;
	

}
