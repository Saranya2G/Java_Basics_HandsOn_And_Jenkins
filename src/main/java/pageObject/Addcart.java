package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Addcart {
	
	WebDriver driver;
	
	public Addcart(WebDriver driver) {
		
		this.driver = driver;
	}
	
	@FindBy(id = "shopping_cart_container")
	public static WebElement Container;
	
	@FindBy(id ="remove-sauce-labs-backpack")
	public static WebElement remove;
}
