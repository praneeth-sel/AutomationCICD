package rahulshettyacademy.tests;


import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.TestComponenents.BaseTest;
import rahulshettyacademy.TestComponenents.Retry;
import rahulshettyacademy.pageobject.CartPage;
import rahulshettyacademy.pageobject.CheckOutPage;
import rahulshettyacademy.pageobject.ConfirmationPage;
import rahulshettyacademy.pageobject.LandingPage;
import rahulshettyacademy.pageobject.ProductCatalogue;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import javax.swing.GroupLayout.Group;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.Test;







public class ErrorValidationsTest extends BaseTest{

	@Test (groups={"ErrorHanding"},retryAnalyzer=Retry.class)
	public void LoginErrorValidation() throws IOException {
		
		
		landingpage.loginApplication("kattapraneeth94@gmail.com", "Saketa@12345");
<<<<<<< HEAD
		Assert.assertEquals("Incorrect email or password.", landingpage.getErrorMessage());
=======
		Assert.assertEquals("Incorrect email password.", landingpage.getErrorMessage());
>>>>>>> e3bdbab61deb5dd4ee644f0bd900766c09dac6a8
	}
	
	@Test
	public void ProductErrorValidation() throws InterruptedException, IOException {
		
		String productName="ZARA COAT 3";
		LandingPage landingPage= lauchApplication();
		ProductCatalogue productCatalogue= landingPage.loginApplication("kattapraneeth94@gmail.com", "Saketa@1234");
		List<WebElement>products= productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
		CartPage cartPage= productCatalogue.goToCartPage();
		Boolean match=cartPage.VerifyProductDisplay("ZARA COAT 33");
		Assert.assertFalse(match);
		
	
	}
	
}
