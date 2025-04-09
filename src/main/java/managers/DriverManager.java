package managers;

import java.util.function.Supplier;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import browserOptions.RemoteHostOptions;
import utilities.ConfigReader;

public abstract class DriverManager {
	protected WebDriver driver;
	protected static ThreadLocal<RemoteWebDriver> remote_driver= new ThreadLocal<RemoteWebDriver>();
	String remoteHost_sauce_url= RemoteHostOptions.sauce_url.get();
	String remoteHost_grid_url= RemoteHostOptions.grid_url.get();
	
	protected static final Supplier<ConfigReader> configSupplier = () ->
	{
		return new ConfigReader();
	};

	abstract public WebDriver createDriver();
	abstract public WebDriver getDriver();
	
}
