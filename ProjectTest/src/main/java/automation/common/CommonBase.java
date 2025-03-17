package automation.common;

import java.time.Duration;
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
	public static String getElementValue (Element element) {
		return element.getValue();
	}
	public WebDriver findElementByID(Element element) {
		return (WebDriver) driver.findElement(By.id(getElementValue(element)));
	}

	public void clickElement(Element element) {
		WebElement webElement = (WebElement) findElementByID(element);
		if(element != null) {
			webElement.click();
		}else {
			System.out.println("Not found element");
		}
	}
	public WebElement waitElementVisible(By Locator, int timeoutSecond) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSecond));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(Locator));
	}
}
