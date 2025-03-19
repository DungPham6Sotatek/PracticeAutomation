package automation.pageLocator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import automation.constant.CT_AmazonDashboard;

public class AmazonDashboardPage {
	private WebDriver driver;
	
	public AmazonDashboardPage(WebDriver _driver) {
		this.driver = _driver;
	}
	
	public void searchFunctionAmazon(String searchValue) {
		WebElement searchInput = driver.findElement(By.id(CT_AmazonDashboard.SEARCH_INPUT));
		if(searchInput.isDisplayed()) {
			searchInput.clear();
			searchInput.sendKeys(searchValue);
		}
		WebElement searchSubmit = driver.findElement(By.id(CT_AmazonDashboard.SEARCH_SUBMIT));
		if(searchSubmit.isDisplayed()) {
			searchSubmit.click();
		}
	}
}
