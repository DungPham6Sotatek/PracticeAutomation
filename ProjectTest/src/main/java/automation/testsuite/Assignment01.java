package automation.testsuite;

import static org.testng.Assert.assertTrue;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.testng.annotations.*;

import automation.common.CommonBase;
import automation.constant.CT_AmazonSearchResult;
import automation.constant.CT_EbaySearchResult;
import automation.constant.CT_LazadaSearchResult;
import automation.constant.CT_PageURL;
import automation.pageLocator.AmazonDashboardPage;
import automation.pageLocator.EbayDashboardPage;
import automation.pageLocator.LazadaDashboardPage;

public class Assignment01 extends CommonBase{
	@BeforeMethod
	public void openBrowser() {
		driver = initBrowser(CT_PageURL.EBAY_URL);
	}
	
	@Test
	public void comparePrice() {
		
		//ebay
		EbayDashboardPage ebaySearch = new EbayDashboardPage(driver);
		ebaySearch.searchFunctionEBay("Iphone 16");
		
		String [] allPrice = new String[2];
		String ebayProductPrice = driver.findElement(By.xpath(CT_EbaySearchResult.EBAY_PRICE)).getText();
		allPrice[0] = ebayProductPrice;
		
		
		//lazada
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get(CT_PageURL.LAZADA_URL);
		LazadaDashboardPage lazadaSearch = new LazadaDashboardPage(driver);
		lazadaSearch.searchFunctionLazada("Iphone 16");
		String lazadaProductPrice = driver.findElement(By.xpath(CT_LazadaSearchResult.LAZADA_PRICE)).getText();
		System.out.println(driver.findElement(By.xpath(CT_LazadaSearchResult.LAZADA_PRICE)).getText());
		allPrice[1] = lazadaProductPrice;
		
		//sort
		System.out.println(allPrice);
		double[] newAllPrice = sortArray(allPrice);
		System.out.println(newAllPrice);
		
		
		
		
		
		
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}
}
