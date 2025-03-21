package automation.common;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import automation.constant.*;


public class CommonBase {
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
	
	public double[] sortArray(String[] arr) {
		
		double[] numericPrices = new double[2];
		for (int i = 0 ; i <arr.length; i++) {
			numericPrices[i] = extractPrice(arr[i]) ;
		}
		System.out.println(Arrays.toString(numericPrices));

		Arrays.sort(numericPrices);
		
		System.out.println(Arrays.toString(numericPrices));
		
		  
		return numericPrices;
	}
	
	public double extractPrice(String priceText) {
		return Double.parseDouble(priceText.replaceAll("[^0-9.]", ""));
	}
	}



