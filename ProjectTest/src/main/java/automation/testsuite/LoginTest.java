package automation.testsuite;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import automation.common.CommonBase;


public class LoginTest extends CommonBase{
	String ebayPrice; 
	@Test
	public void TestO1() {
		driver = initBrowser("https://www.ebay.com/");
		WebElement inputSearch = driver.findElement(By.id("gh-ac"));
		inputSearch.click();
		inputSearch.sendKeys("iPhone 16");
		WebElement btnSearch = driver.findElement(By.id("gh-search-btn"));
		btnSearch.click();
		WebElement primaryPrice = driver.findElement(By.xpath("//div[@class= 's-item__details-section--primary']//span"));
		
		primaryPrice = waitElementVisible(By.xpath("//div[@class= 's-item__details-section--primary']//span"), 20);
		ebayPrice = primaryPrice.getText();
		System.out.println(ebayPrice);
		driver.quit();
	}
}
