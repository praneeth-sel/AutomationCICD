package rahulshettyacademy.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent{
	WebDriver driver;
	
	public CartPage(WebDriver driver) 
	{
			// TODO Auto-generated constructor stub
	    super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css=".totalRow button")
	WebElement checkoutEle;
	
	@FindBy(css=".cart h3")
	private List<WebElement> productTittles;
	
	
	//driver.findElement(By.cssSelector(".totalRow button")).click();
	//List <WebElement> cartproducts= driver.findElements(By.cssSelector(".cart h3"));
	
	public Boolean VerifyProductDisplay(String productName)
	{
		Boolean match=	productTittles.stream().anyMatch(cartproduct->cartproduct.getText().equalsIgnoreCase(productName));
		return match;
	}
	
	public CheckOutPage toGoToCheckout()
	{
		checkoutEle.click();
		return new CheckOutPage(driver);
	}
 
}
