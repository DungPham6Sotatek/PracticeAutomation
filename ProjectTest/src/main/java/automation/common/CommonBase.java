package automation.common;

import java.lang.reflect.Array;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import automation.constant.*;
import automation.pageLocator.ProductInfomation;


public class CommonBase {
	List<ProductInfomation> productInfoList = new ArrayList<ProductInfomation>();
	
	
	
	public WebDriver driver;
	
	public WebDriver initBrowser(String url) {
//		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir" + "C:\\eclipse-workspace\\ProjectTest\\driver\\chromedriver.exe"));
		WebDriverManager.chromedriver().setup(); 
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
		
	}
	public void findElementByID(String value) {
		driver.findElement(By.id(value));
	}
	public void findElementByXpath(String value) {
		driver.findElement(By.xpath(value));
	}
	
//	public double[] sortArray(String[] arr) {
//		
//		double[] numericPrices = new double[2];
//		for (int i = 0 ; i <arr.length; i++) {
//			numericPrices[i] = extractPrice(arr[i]) ;
//		}
//		System.out.println(Arrays.toString(numericPrices));
//
//		Arrays.sort(numericPrices);
//		
//		System.out.println(Arrays.toString(numericPrices));
//		
//		  
//		return numericPrices;
//	}
	
	public void ConvertEbayPrices(List<WebElement> ebayProducts) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(CT_EbaySearchResult.EBAY_PRODUCTS)));
		for (WebElement product : ebayProducts) {
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(CT_EbaySearchResult.PRODUCT_NAME)));		
			String name = product.findElement(By.xpath(".//span[@role = 'heading']")).getText();
			
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(CT_EbaySearchResult.PRODUCT_LINK)));
			String link = product.findElement(By.xpath(".//a[@class = 's-item__link']")).getAttribute("href");
			
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(CT_EbaySearchResult.PRODUCT_PRICE)));
			String price = product.findElement(By.xpath(".//span[@class = 's-item__price']")).getText();
			
//			 System.out.println("Product Name: " + name);
//	         System.out.println("Product Price: " + price);
//	         System.out.println("Product Link: " + link);
			
			if(price == null || price.trim().isEmpty()) continue;
			if (price.contains("to")) {
	              String[] parts = price.split("to");
	              double low = parsePrice(parts[0]);
	              double high = parsePrice(parts[1]);
	              
	              productInfoList.add(new ProductInfomation("Ebay", name, low, link));
	              productInfoList.add(new ProductInfomation("Ebay", name, high, link));
	            } else {
	            	double convertPrice = parsePrice(price);
	            	productInfoList.add(new ProductInfomation("Ebay", name, convertPrice, link) );
	            }
			}
//		System.out.print(productInfoList);
	}
		
		
		// handle ebay list
		
		
	public void ConvertLazadaPrices(List<WebElement> lazadaProducts) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		wait.until(ExpectedConditions.visibilityOfAllElements(lazadaProducts));
		 for (WebElement product : lazadaProducts) {
			 	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(CT_LazadaSearchResult.PRODUCT_NAME)));	
			 	WebElement nameElement = product.findElement(By.xpath(".//a"));
			 	System.out.println(nameElement.getText());
			 	String name = nameElement.getText();
			 	
			 	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(CT_LazadaSearchResult.PRODUCT_LINK)));	
				String link = product.findElement(By.xpath(".//a")).getAttribute("href");
				
				wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(CT_LazadaSearchResult.PRODUCT_PRICE)));
				String price = product.findElement(By.xpath(".//span[@class = 'ooOxS']")).getText();
//				System.out.println(price);
				
		        if (price == null || price.trim().isEmpty()) continue;
		        double convertPrice = parsePrice(price);
		        productInfoList.add(new ProductInfomation("Lazada", name, convertPrice, link));
		    }
		 
		 //sort
//		 System.out.print(productInfoList);
		
	}
	
	public void sortProductList() {
	    // Sắp xếp danh sách theo giá (productPrice) của sản phẩm
	    productInfoList.sort(Comparator.comparingDouble(p -> p.productPrice));
	    
	    // In kết quả sau khi đã sắp xếp
	    System.out.println("Sản phẩm sau khi sắp xếp theo giá:");
	    for (ProductInfomation info : productInfoList) {
	        System.out.println(info);
	    }
	}
		//handle lazada list
		
		
	
	 public static double parsePrice(String input) {
	        String cleaned = input.replaceAll("[^\\d.,]", "").trim();

	        // handle split
	        if (cleaned.contains(",") && cleaned.contains(".")) {
	            cleaned = cleaned.replace(",", "");
	        } else if (cleaned.contains(",")) {
	            cleaned = cleaned.replace(",", "");
	        }

	        return Double.parseDouble(cleaned);
	    }
//	 public static List<ProductInfomation> convertPriceToString (List<ProductInfomation> productList) {
//		 List<ProductInfomation> stringProductList = new ArrayList<>();
//		 for (ProductInfomation product : productList) {
//			 String fomatted = String.format("%,.2f VND", product.productPrice);
//
//			 stringProductList.add(new ProductInfomation(product.website, p, 0, fomatted));
//		}
//		 return stringProductList;
//	 }
	 
	 public void ProductInfo(String website, String productName, double productPrice, String productLink) {
		System.out.print("Website: " + website + "\n"
						 + productName + "\n"
						 + productPrice + "VND"
						 + productLink);
	 }

}



