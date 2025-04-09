package browserOptions;

import java.util.function.Supplier;

import org.openqa.selenium.MutableCapabilities;

import utilities.SeleniumUtilities;

public class SauceOptions {
	
	public static final Supplier<MutableCapabilities> sauce_options =() ->
	{
		MutableCapabilities capabilities = new MutableCapabilities();
		capabilities.setCapability("username", System.getenv("SAUCE_USERNAME"));
		capabilities.setCapability("accesskey", System.getenv("SAUCE_ACCESS_KEY"));
		capabilities.setCapability("tunnel-identifier", System.getenv("SAUCE_CONNECT_TUNNEL_IDENTIFIER"));
		capabilities.setCapability("build", "Test_Application_"+SeleniumUtilities.timeStamp());
		return capabilities;
	};

}
