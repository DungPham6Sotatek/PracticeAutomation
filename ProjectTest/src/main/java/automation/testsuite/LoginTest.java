package automation.testsuite;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import automation.common.CommonBase;


public class LoginTest extends CommonBase{
	String ebayPrice;
	
	@BeforeMethod
	public void openBrowser() {
		driver = initBrowser("https://www.ebay.com/");
	}
	
	
	@Test
	public void TestO1() {
		
		WebElement inputSearch = driver.findElement(By.id("gh-ac"));
		inputSearch.click();
		inputSearch.sendKeys("iPhone 16");
		WebElement btnSearch = driver.findElement(By.id("gh-search-btn"));
		btnSearch.click();
		WebElement primaryPrice = driver.findElement(By.xpath("//div[@class= 's-item__details-section--primary']//span"));
		
		primaryPrice = waitElementVisible(By.xpath("//div[@class= 's-item__details-section--primary']//span"), 20);
		
//		ebayPrice = primaryPrice.getText();
//		System.out.println(ebayPrice);
		driver.quit();
	}
}
