package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Productpage {
	
	WebDriver driver;
	
	public Productpage(WebDriver driver) {
		
		this.driver = driver;
	}
	
	@FindBy(id = "item_4_title_link")
	public static WebElement product;
	
	@FindBy(id ="add-to-cart-sauce-labs-backpack")
	public static WebElement addcart;
	

}
