package factory;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import enums.DriverType;
import managers.ChromeDriverManager;
import managers.DriverManager;
import managers.EdgeDrivermanager;

public class DriverFactory {
	
	private static final Map<DriverType, Supplier<DriverManager>> driverMap = new HashMap<DriverType, Supplier<DriverManager>>();
	
	public static final Supplier<DriverManager> chromeDriverSupplier =() ->
	{
		return new ChromeDriverManager();
	};
	
	public static final Supplier<DriverManager> edgeDriverSupplier =() ->
	{
		return new EdgeDrivermanager();
	};
	
	static {
		driverMap.put(DriverType.CHROME, chromeDriverSupplier);
		driverMap.put(DriverType.EDGE, edgeDriverSupplier);
	}
	
	public static final DriverManager getManager(DriverType type) {
		return driverMap.get(type).get();
	}

}
