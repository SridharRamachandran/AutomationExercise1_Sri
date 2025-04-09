package stepDefinitions;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilities.ConfigReader;
import utilities.SeleniumUtilities;

import org.apache.log4j.xml.DOMConfigurator;

public class Hooks {
	public static Scenario scenario;
	ConfigReader load = new ConfigReader();
	managers.DriverManager driver_manager;
	public static ThreadLocal<String> scenario_name= new ThreadLocal<String>();
	
	@Before
	public void before(Scenario scenario) {
		this.scenario=scenario;
		DOMConfigurator.configure(System.getProperty("user.dir")+"/config/log4j.xml");
		scenario_name.set(scenario.getName());
	}
	
	@After
	public void quitBrowser(Scenario scenario) {
		String browser = load.getBrowserName();
		System.out.println("Entered into hooks");
		if(scenario.isFailed()) {
			try {
				byte[] path = ((TakesScreenshot)DriverFactory.getManager(SeleniumUtilities.getBrowser(browser)).getDriver()).getScreenshotAs(OutputType.BYTES);
				scenario.attach(path, "image/png", "screenshot");
			} catch (WebDriverException e) {				
				e.printStackTrace();
			}			
		}
		if(DriverFactory.getManager(SeleniumUtilities.getBrowser(browser)).getDriver()!=null) {
			System.out.println(DriverFactory.getManager(SeleniumUtilities.getBrowser(browser)).getDriver());
			DriverFactory.getManager(SeleniumUtilities.getBrowser(browser)).getDriver().quit();
		}
	}

}
