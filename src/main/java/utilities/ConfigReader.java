package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Map;
import java.util.Properties;

import enums.DriverType;
import enums.EnvironmentType;

public class ConfigReader {
	protected static Properties properties;
	protected static String environmentName;
	static Map<String,String> TestDataInMap;
	
	public ConfigReader() {
		try {
			File propFile=new File("config/config.properties");
			FileInputStream FIS = new FileInputStream(propFile);
			properties = new Properties();
			properties.load(FIS);
			environmentName=System.getProperty("environment")!=null?System.getProperty("environment") : properties.getProperty("environment");
			//loadEnv_Details(environmentName);
		}
		catch(Exception e) {
			System.out.println("Exception from reading config file "+e.getMessage());
		}
	}
	
		
	public String getChromerDriverPath() {
		return properties.getProperty("Chromedriverpath");
	}
	
	public String getEdgeDriverPath() {
		return properties.getProperty("Edgedriverpath");
	}
	
	public String getRemoteHostName() {		
		return System.getProperty("remoteHostName")!=null?System.getProperty("remoteHostName"):properties.getProperty("remoteHostName");
	}
	
	public String getRunSetUp() {
		return System.getProperty("runSetup")!=null?System.getProperty("runSetup"):properties.getProperty("runSetup");
	}
	
	
	
	public DriverType getBrowser() {
		if(TestDataInMap.get("Browser").equalsIgnoreCase("chrome")) {
			return DriverType.CHROME;
		}
		if(TestDataInMap.get("Browser").equalsIgnoreCase("edge")) {
			return DriverType.EDGE;
		}
		else throw new RuntimeException("Browser not matched with defeined values "+TestDataInMap.get("Browser"));
	}
	
	
	public Long getImplicitTimeOut() {
		return Long.parseLong(properties.getProperty("implicitlywait"));
	}
	
	public EnvironmentType getEnvironment() {
		if(environmentName.equalsIgnoreCase("test1")) 
			return EnvironmentType.TEST1;
		if(environmentName.equalsIgnoreCase("test2")) 
			return EnvironmentType.TEST2;
		else throw new RuntimeException(" Environment is not defined "+environmentName);		
	}
	
	public void setBrowser(String browser) {
		properties.setProperty("browser",browser);
	}
	
	public String getBrowserName() {
		return properties.getProperty("browser");
	}

	

}
