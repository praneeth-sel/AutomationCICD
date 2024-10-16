package rahulshettyacademy.stepDefinations;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import rahulshettyacademy.TestComponenents.BaseTest;
import rahulshettyacademy.pageobject.CartPage;
import rahulshettyacademy.pageobject.CheckOutPage;
import rahulshettyacademy.pageobject.ConfirmationPage;
import rahulshettyacademy.pageobject.LandingPage;
import rahulshettyacademy.pageobject.ProductCatalogue;

public class stepDefinationImpl extends BaseTest {
 
	public LandingPage landingPage;
	public ProductCatalogue productCatalogue;
	public ConfirmationPage confirmationPage;
	
	@Given("I Landed on the Ecommerce Page")
	public void I_Landed_on_the_Ecommerce_Page() throws IOException
	{
		landingPage=lauchApplication();
	}
	
	@Given ("^Logged with username (.+) and password (.+)$")
	public void Logged_with_username_and_password(String username,String password)
	{
		productCatalogue = landingpage.loginApplication(username,password);
	}
	
	 @When ("^I add Product (.+) in cart$")
	 public void i_add_product_to_cart(String productName) throws InterruptedException
	 {
	 List<WebElement>products= productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
	 }
	 
	 @When("^Checkout (.+) and submit the order$")
	 public void checkout_submit_order(String productName)
	 {
		 CartPage cartPage= productCatalogue.goToCartPage();
			Boolean match=cartPage.VerifyProductDisplay(productName);
			Assert.assertTrue(match);
			CheckOutPage checkoutPage=cartPage.toGoToCheckout();
			checkoutPage.selectCountry("india");
			confirmationPage= checkoutPage.submitOrder();	
	 }
	 
	 @Then("{string} message is displayed on ConfirmationPage")
	 public void message_displayed_confirmationpage(String string)
	 {
		 String confrimmessage=confirmationPage.getConfirmationMessage();
			Assert.assertTrue(confrimmessage.equalsIgnoreCase(string));
			driver.close();
	 }
	 
	  @Then("{string} message is displayed")
	    public void incorrectEmailPasswordMessageIsDisplayed(String strArg1) throws Throwable{
	     Assert.assertEquals("Incorrect email or password.", landingpage.getErrorMessage());
	        		driver.close();
	  }
}
	 