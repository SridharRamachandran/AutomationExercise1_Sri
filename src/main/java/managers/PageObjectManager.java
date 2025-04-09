package managers;

import org.openqa.selenium.WebDriver;

import applicationPages.WebFromPage;

public class PageObjectManager {
	private WebDriver driver;
	private WebFromPage homePage;
	public PageObjectManager(WebDriver driver) {
		this.driver=driver;
	}
	
	public WebFromPage getHomePage() {
		return (homePage==null)? homePage = new WebFromPage(driver) : homePage;
	}
	
}
