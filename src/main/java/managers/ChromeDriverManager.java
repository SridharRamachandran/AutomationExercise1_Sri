package managers;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import browserOptions.ChromeBrowserOptions;

public class ChromeDriverManager extends DriverManager {

	@Override
	public WebDriver createDriver() {
		if(configSupplier.get().getRunSetUp().contains("remote")) {
			if(configSupplier.get().getRemoteHostName().contains("sauce")) {
				try {
					remote_driver.set(new RemoteWebDriver(new URL(remoteHost_sauce_url), ChromeBrowserOptions.chrome_remoteOptions_sauce.get()));
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(configSupplier.get().getRemoteHostName().contains("grid")) {
				try {
					remote_driver.set(new RemoteWebDriver(new URL(remoteHost_grid_url), ChromeBrowserOptions.chrome_remoteOptions_grid.get()));
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			
			}
		}
		else if(configSupplier.get().getRunSetUp().contains("local")) {
		 System.getProperty("webdriver.chromer.driver",configSupplier.get().getChromerDriverPath());
		 remote_driver.set(new ChromeDriver(ChromeBrowserOptions.chrome_localOptions.get()));
		}
		getDriver().manage().deleteAllCookies();
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(configSupplier.get().getImplicitTimeOut()));
		return getDriver();
	}


	public WebDriver getDriver() {
		// TODO Auto-generated method stub
		return remote_driver.get();
	}
	

}
