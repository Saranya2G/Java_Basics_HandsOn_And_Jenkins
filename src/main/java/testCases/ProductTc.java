package testCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pageObject.Productpage;

public class ProductTc extends Baseclass1{
	@Test
	public void product() throws InterruptedException {
		/*Logintestcase li = new Logintestcase();
		li.login();*/
		//Thread.sleep(3000);
		PageFactory.initElements(driver, Productpage.class);
		Productpage.product.click();
		//Thread.sleep(3000);
		Productpage.addcart.click();
		//Thread.sleep(3000);
		
	}

}
