package automation.pageLocator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import automation.constant.CT_AmazonDashboard;
import automation.constant.CT_EbayDasboard;

public class EbayDashboardPage {
	private WebDriver driver;
	public EbayDashboardPage(WebDriver _driver) {
		this.driver = _driver;
	}
	
	public void searchFunctionEBay(String searchValue) {
		WebElement searchInput = driver.findElement(By.id(CT_EbayDasboard.SEARCH_INPUT));
		if(searchInput.isDisplayed()) {
			searchInput.clear();
			searchInput.sendKeys(searchValue);
		}
		WebElement searchSubmit = driver.findElement(By.id(CT_EbayDasboard.SEARCH_BUTTON));
		if(searchSubmit.isDisplayed()) {
			searchSubmit.click();
		}
	}
}
