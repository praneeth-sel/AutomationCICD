package rahulshettyacademy.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class CheckOutPage extends AbstractComponent {
	WebDriver driver;	
	
	public CheckOutPage(WebDriver driver)
	{
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="(//button[contains(@class,'ta-item')])[2]")
	WebElement selectCountry;
	
	@FindBy(xpath="//a[contains(@class,'btnn')]")
	WebElement submit;
	
	@FindBy(css="[placeholder='Select Country']")
	WebElement Counrty;
	
	By results =By.cssSelector(".ta-results");

	public void selectCountry(String CountryName)
	{
		Actions a=new Actions(driver);
		a.sendKeys(Counrty, "india").build().perform();
		waitForElementToAppear(By.cssSelector(".ta-results"));
		selectCountry.click();
		
	}

	public ConfirmationPage submitOrder()
	{
		submit.click();
		return new ConfirmationPage(driver);
		
	}
	
}
