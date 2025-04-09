package browserOptions;

import java.util.function.Supplier;

public class RemoteHostOptions {

	public static final Supplier<String> sauce_url= () ->	
	{
		String sauce_url="https://"+System.getenv("SAUCE_USERNAME")+":"+System.getenv("SAUCE_ACCESS_KEY")+"remainingpartofURL:443/wd/hub";
		return sauce_url;
	};
	
	public static final Supplier<String> grid_url= () ->	
	{
		//for cloud
		// String grid_url = "https://......"
		String grid_url="http://ipaddress:4444";
		return grid_url;
	};
	
	public static final Supplier<String> docker_url= () ->	
	{
		//for cloud
		// String docker_url = "https://......"
		String docker_url="http://ipaddress:4444";
		return docker_url;
	};
	
}
