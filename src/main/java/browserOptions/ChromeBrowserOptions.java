package browserOptions;

import java.util.function.Supplier;

import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeBrowserOptions {
	
	public static final Supplier<ChromeOptions> chrome_localOptions = () ->
	{
		ChromeOptions local_options= new ChromeOptions();
		local_options.addArguments("start-maximized");
		local_options.addArguments("disable-infobars");
		local_options.addArguments("--disable-extensions");
		local_options.addArguments("--disable-gpu");
		local_options.addArguments("--disable-dev-shm-usage");
		local_options.addArguments("--ignore-ssl-errors=yes");
		local_options.addArguments("--ignore-certificate-errors");
		return local_options;
		
	};
	
	public static final Supplier<ChromeOptions> chrome_remoteOptions_sauce = () ->
	{
		ChromeOptions remote_options= new ChromeOptions();
		remote_options.setPlatformName("Windows 11");
		remote_options.setBrowserVersion("107");
		remote_options.addArguments("start-maximized");		
		remote_options.addArguments("--ignore-ssl-errors=yes");
		remote_options.addArguments("--ignore-certificate-errors");
		remote_options.setCapability(ChromeOptions.CAPABILITY, remote_options);
		remote_options.setCapability("sauce:options",SauceOptions.sauce_options.get());
		return remote_options;		
	};
	
	public static final Supplier<ChromeOptions> chrome_remoteOptions_grid = () ->
	{
		ChromeOptions remote_options= new ChromeOptions();
		remote_options.setCapability("platformName", "Windows");		
		remote_options.addArguments("start-maximized");		
		remote_options.addArguments("--ignore-ssl-errors=yes");
		remote_options.addArguments("--ignore-certificate-errors");
		remote_options.addArguments("Env:Environment","Test");
		remote_options.setCapability(ChromeOptions.CAPABILITY, remote_options);		
		return remote_options;		
	};
	
	

}
