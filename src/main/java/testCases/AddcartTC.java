package testCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pageObject.Addcart;

public class AddcartTC extends Baseclass1 {
	@Test
	public void cart() throws InterruptedException {
		/*ProductTC PT = new ProductTC();
		PT.product();*/
		PageFactory.initElements(driver, Addcart.class);
		Addcart.Container.click();
		//Thread.sleep(2000);
		Addcart.remove.click();
		//Thread.sleep(2000);
	}

}
