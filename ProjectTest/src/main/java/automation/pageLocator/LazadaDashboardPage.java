package automation.pageLocator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import automation.constant.CT_EbayDasboard;
import automation.constant.CT_LazadaDashboard;

public class LazadaDashboardPage {
	private WebDriver driver;
	
	public LazadaDashboardPage(WebDriver _driver) {
		this.driver = _driver;
	}
	
	public void searchFunctionLazada(String searchValue) {
		WebElement searchInput = driver.findElement(By.id(CT_LazadaDashboard.SEARCH_INPUT));
		if(searchInput.isDisplayed()) {
			searchInput.clear();
			searchInput.sendKeys(searchValue);
		}
		WebElement searchSubmit = driver.findElement(By.xpath(CT_LazadaDashboard.SEARCH_SUBMIT));
		if(searchSubmit.isDisplayed()) {
			searchSubmit.click();
		}
	}
}
