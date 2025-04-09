package utilities;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import enums.DriverType;

public class SeleniumUtilities {
	private static DriverType driverType;
	
	public static DriverType getBrowser(String browserName) {
		switch(browserName.toUpperCase()) {
		case "CHROME":
			System.out.println("Chrome browser used for execution....");
			driverType=DriverType.CHROME;
			break;
		case "EDGE":
			System.out.println("Edge browser used for execution....");
			driverType=DriverType.EDGE;
			break;				
		}
		return driverType;
	}
	public static void openApplicationURL(WebDriver driver,String url) {
		driver.get(url);
	}
	
	public static void clickOnElement(WebElement element) {
		element.click();
	}
	
	public static void sendKeys(WebElement element,String value) {
		element.sendKeys(value);
	}
	
	public static void select_ByVisibleText(WebDriver driver,WebElement element,String value) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(element));
		Select select = new Select(element);
		select.selectByVisibleText(value);
	}
	
	public static String getTextFromWebElement(WebElement element) {
		return element.getText();
	}
	
	public static String getAttributevalue(WebElement element,String attributeName) {
		return element.getAttribute(attributeName);
	}
	
	public static String timeStamp() {
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd_hh-mm-ss");
		return format.format(date);
		
	}

}
