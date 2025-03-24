package automation.testsuite;

import static org.testng.Assert.assertTrue;

import java.lang.reflect.Array;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import automation.common.CommonBase;
import automation.constant.CT_AmazonSearchResult;
import automation.constant.CT_EbaySearchResult;
import automation.constant.CT_LazadaSearchResult;
import automation.constant.CT_PageURL;
import automation.pageLocator.AmazonDashboardPage;
import automation.pageLocator.EbayDashboardPage;
import automation.pageLocator.LazadaDashboardPage;
import automation.pageLocator.ProductInfomation;

public class Assignment01 extends CommonBase{
//	List<ProductInfomation> productInfo = new ArrayList<ProductInfomation>();
	@BeforeMethod
	public void openBrowser() {
		driver = initBrowser(CT_PageURL.EBAY_URL);
	}
	
	@Test
	public void comparePrice() throws InterruptedException {
		
		//ebay
		EbayDashboardPage ebaySearch = new EbayDashboardPage(driver);
		ebaySearch.searchFunctionEBay("Iphone 16");
		String ebayWebsite = "Ebay";
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath(CT_EbaySearchResult.EBAY_PRODUCTS))));
		List<WebElement> allProductOnEbay = driver.findElements(By.xpath(CT_EbaySearchResult.EBAY_PRODUCTS));
		
		
		ConvertEbayPrices(allProductOnEbay);
		
		Thread.sleep(2000);
		
		// switch URL
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get(CT_PageURL.LAZADA_URL);
		
		LazadaDashboardPage lazadaSearch = new LazadaDashboardPage(driver);
		lazadaSearch.searchFunctionLazada("Iphone 16");
		wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath(CT_LazadaSearchResult.LAZADA_PRODUCT))));
		List<WebElement> allProductOnLazada = driver.findElements(By.xpath(CT_LazadaSearchResult.LAZADA_PRODUCT));
		
		
		ConvertLazadaPrices(allProductOnLazada);
		sortProductList();
	}
		
//		System.out.println(productInfoList);
		
//		List<String> allPriceTextOnLazada = new ArrayList<String>();
		
//		for (WebElement productOnEbay : allProductOnEbay) {
//			
//			String productName = productOnEbay.findElement(By.xpath(CT_EbaySearchResult.PRODUCT_NAME)).getText();
//			
//			double convertedPriceProduct = parsePrice(productOnEbay.findElement(By.xpath(CT_EbaySearchResult.PRODUCT_NAME)).getText());
//			String productLink = productOnEbay.findElement(By.xpath(CT_EbaySearchResult.PRODUCT_LINK)).getText();
//			ProductInfomation productItem = new ProductInfomation(ebayWebsite, productName, convertedPriceProduct, productLink);
//			productInfo.add(productItem);
//		}
//		System.out.println(productInfo.toString());
		
//		List<String> allPriceTextOnEbay = new ArrayList<String>();
//		for (WebElement webElementPriceOnEbay : allElementPriceOnEbay) {
//			allPriceTextOnEbay.add(webElementPriceOnEbay.getText());
//		}
//		Thread.sleep(5000);
//		System.out.println(allPriceTextOnEbay);
		

		
		//lazada
//		
//		for (WebElement webElementPriceOnLazada : allElementPriceOnLazada) {
//			allPriceTextOnLazada.add(webElementPriceOnLazada.getText());
//		}
//		System.out.println(allPriceTextOnLazada);
//		
//		//sort
//		List<Double> allDoublePrices = MergedPrices(allPriceTextOnEbay, allPriceTextOnLazada);
//		List<String> allStringPrices = convertDoubleToString(allDoublePrices);
//		
//		System.out.println(allStringPrices);
		
		
		
//		String linkEbayProduct = driver.getCurrentUrl();
//		allPrice[0] = ebayProductPrice;
		
		
		//lazada
//		driver.switchTo().newWindow(WindowType.TAB);
//		driver.get(CT_PageURL.LAZADA_URL);
//		LazadaDashboardPage lazadaSearch = new LazadaDashboardPage(driver);
//		lazadaSearch.searchFunctionLazada("Iphone 16");
//		String lazadaProductPrice = driver.findElement(By.xpath(CT_LazadaSearchResult.LAZADA_PRICE)).getText();
//		String linkLazadaProduct = driver.getCurrentUrl();
//		System.out.println(driver.findElement(By.xpath(CT_LazadaSearchResult.LAZADA_PRICE)).getText());
//		allPrice[1] = lazadaProductPrice;
		
		//sort
//		System.out.println(Arrays.toString(allPrice));
//		List<Double> newAllPrice = extractPriceToDouble(allPrice);
//		List<String> completeSortPRice = convertDoubleToString(newAllPrice);
//		System.out.println("List sortedPrices: " + completeSortPRice);
//		
//		System.out.println("Iphone price on ebay: " +ebayProductPrice + ", product link: " + linkEbayProduct);
//		System.out.println("Iphone price on lazada: " +lazadaProductPrice + ", product link: " + linkLazadaProduct);
		
//	}
//	
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
}


