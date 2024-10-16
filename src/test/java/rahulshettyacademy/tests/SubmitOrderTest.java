package rahulshettyacademy.tests;


import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.TestComponenents.BaseTest;
import rahulshettyacademy.pageobject.CartPage;
import rahulshettyacademy.pageobject.CheckOutPage;
import rahulshettyacademy.pageobject.ConfirmationPage;
import rahulshettyacademy.pageobject.LandingPage;
import rahulshettyacademy.pageobject.OrderPage;
import rahulshettyacademy.pageobject.ProductCatalogue;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.bouncycastle.asn1.dvcs.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SubmitOrderTest extends BaseTest{
	String productName="ZARA COAT 3";
	@Test (dataProvider="getData",groups= {"Purchase"}) 
	public void submitOrder(HashMap<String,String> input) throws IOException, InterruptedException {
		
		
	
		ProductCatalogue productCatalogue= landingpage.loginApplication(input.get("email"),input.get("password"));
		List<WebElement>products= productCatalogue.getProductList();
		productCatalogue.addProductToCart(input.get("products"));
		CartPage cartPage= productCatalogue.goToCartPage();
		Boolean match=cartPage.VerifyProductDisplay(input.get("products"));
		Assert.assertTrue(match);
		CheckOutPage checkoutPage=cartPage.toGoToCheckout();
		checkoutPage.selectCountry("india");
		ConfirmationPage confirmationPage= checkoutPage.submitOrder();
		String confrimmessage=confirmationPage.getConfirmationMessage();
		Assert.assertTrue(confrimmessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
}
	@Test(dependsOnMethods= {"submitOrder"})
	//To verify ZARA COAT 3 is displaying in orders page
	public void OrderHistoryTest()
	{
		ProductCatalogue productCatalogue= landingpage.loginApplication("kattapraneeth94@gmail.com", "Saketa@1234");
		OrderPage orderpage=productCatalogue.goToOrderPage();
		Assert.assertTrue(orderpage.VerifyOrderDisplay(productName));
	}
	
	
		
	@DataProvider
	public Object[][] getData() throws IOException
	{
		HashMap<String,String> map= new HashMap<String,String>();
		List<HashMap<String,String>> data= getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//rahulshettyacademy//data//PurchaseOrder.json");
		return new Object[][] {{data.get(0)},{data.get(1)}};
	}
		
}

/*	map.put("email", "kattapraneeth94@gmail.com");
map.put("password", "Saketa@1234");
map.put("products", "ZARA COAT 3");

HashMap<String,String> map1= new HashMap<String,String>();
map1.put("email", "kattapraneeth98@gmail.com");
map1.put("password", "Saketa@1234");
map1.put("products", "ADIDAS ORIGINAL");*/