package rahulshettyacademy.tests;


import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.pageobject.LandingPage;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;





public class StandAloneTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//new comments added
		String productname="ZARA COAT 3";
		WebDriverManager.chromedriver().setup();
		 WebDriver driver=new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 driver.manage().window().maximize();
		 driver.get("https://rahulshettyacademy.com/client");
		 LandingPage landingpage= new LandingPage(driver);
		 driver.findElement(By.id("userEmail")).sendKeys("kattapraneeth94@gmail.com");
		 driver.findElement(By.id("userPassword")).sendKeys("Saketa@1234");
		 driver.findElement(By.id("login")).click();
		 WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		 
		List<WebElement> products= driver.findElements(By.cssSelector(".mb-3"));
	WebElement prod=products.stream().filter(product->
		 product.findElement(By.cssSelector("b")).getText().equals("ZARA COAT 3")).findFirst().orElse(null);
		 prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		

wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
//ng-animating
wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
driver.findElement(By.cssSelector("[routerlink*=cart]")).click();

List <WebElement> cartproducts= driver.findElements(By.cssSelector(".cart h3"));
	Boolean match=	cartproducts.stream().anyMatch(cartproduct->cartproduct.getText().equalsIgnoreCase(productname));
	Assert.assertTrue(match);
	driver.findElement(By.cssSelector(".totalRow button")).click();
	
	Actions a=new Actions(driver);
	a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "india").build().perform();
	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".ta-results")));
	driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
	driver.findElement(By.xpath("//a[contains(@class,'btnn')]")).click();
	String confrimmessage=driver.findElement(By.cssSelector(".hero-primary")).getText();
	Assert.assertTrue(confrimmessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

	driver.close();
	
}
}
