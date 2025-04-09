package utilities;

import java.util.HashMap;
import java.util.Map;

public class TestDataHandler {
	Map<String,String> testDataHandler = new HashMap<String, String>();
	
	public Map<String,String> getTestDataHandler(){
		return testDataHandler;
	}
	
	public void setTestDataHandler(Map<String,String> testDataHandler ){
		this.testDataHandler=testDataHandler;
	}

}
