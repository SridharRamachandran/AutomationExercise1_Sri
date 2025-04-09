package browserOptions;

import java.util.function.Supplier;

import org.openqa.selenium.edge.EdgeOptions;


public class EdgeBrowserOptions {
	public static final Supplier<EdgeOptions> edge_localOptions = () ->
	{
		EdgeOptions local_options= new EdgeOptions();
		local_options.addArguments("start-maximized");		
		local_options.addArguments("--ignore-ssl-errors=yes");
		local_options.addArguments("--ignore-certificate-errors");
		local_options.setCapability("USE_CHROMIUM", "ms:edgeChromium");
		return local_options;
		
	};
	
	public static final Supplier<EdgeOptions> edge_remoteOptions_sauce = () ->
	{
		EdgeOptions remote_options= new EdgeOptions();
		remote_options.setPlatformName("Windows 11");		
		remote_options.addArguments("start-maximized");		
		remote_options.setCapability("sauce:options",SauceOptions.sauce_options.get());
		return remote_options;		
	};
	
	public static final Supplier<EdgeOptions> edge_remoteOptions_grid = () ->
	{
		EdgeOptions remote_options= new EdgeOptions();
		remote_options.setCapability("platformName", "Windows");		
		remote_options.addArguments("start-maximized");		
		remote_options.addArguments("--ignore-ssl-errors=yes");
		remote_options.addArguments("--ignore-certificate-errors");
		remote_options.addArguments("Env:Environment","Test");
		remote_options.setCapability(EdgeOptions.CAPABILITY, remote_options);		
		return remote_options;		
	};
}
