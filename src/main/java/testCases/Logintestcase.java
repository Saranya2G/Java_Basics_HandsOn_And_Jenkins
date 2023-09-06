package testCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pageObject.LoginPage;

public class Logintestcase extends Baseclass1{
	@Test
	public void login() {
		PageFactory.initElements(driver, LoginPage.class);
		LoginPage.username.sendKeys("standard_user");
		LoginPage.password1.sendKeys("secret_sauce");
		LoginPage.button.click();
	}

}
