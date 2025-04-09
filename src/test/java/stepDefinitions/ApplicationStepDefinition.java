package stepDefinitions;

import java.util.Map;

import applicationPages.WebFromPage;
import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import managers.DriverManager;
import managers.PageObjectManager;
import utilities.ConfigReader;
import utilities.Log;
import utilities.SeleniumUtilities;

public class ApplicationStepDefinition {

	DriverManager driver_manager;
	ConfigReader loadProp = new ConfigReader();
	PageObjectManager pageManager;
	
	@Given("I open the application in the {string} browser")
	public void launchApplication(String browser) {
		System.out.println("Login works");
		driver_manager = DriverFactory.getManager(SeleniumUtilities.getBrowser(browser));
		driver_manager.createDriver();
		loadProp.setBrowser(browser);
		pageManager = new PageObjectManager(driver_manager.getDriver());
		driver_manager.getDriver().get("https://www.selenium.dev/selenium/web/web-form.html");		
		Log.info("Application openend successfully");
	}
	
	@Then("I enter {string} in the {string} input field")
	public void enterValue_TextField(String value,String Field) {
		WebFromPage webPage= pageManager.getHomePage();	
		webPage.enterValue(value, Field);
		Log.info("Entered the text "+value+" in the field "+Field);
	}
	
	@Then("I select the {string} from the {string} dropdown field")
	public void selectvalue_DropdownField(String value, String dropdownFieldName) {
		WebFromPage webPage= pageManager.getHomePage();
		webPage.selectValue(value, dropdownFieldName);
		Log.info("Selected the value "+value+" from drop down "+dropdownFieldName);
	}
	
	@Then("I click on {string} button")
	public void clickOnButton(String  buttonName) {
		WebFromPage webPage= pageManager.getHomePage();	
		webPage.clickOnButton(buttonName);
		Log.info("Successfully clicked on "+buttonName+ " button");
	}
	
	@And("I verify the {string} success message is displayed")
	public void verifySuccessMessage(String expectedMessage) {
		WebFromPage webPage= pageManager.getHomePage();	
		String actualMessage=webPage.verifySuccessMessage();
		Assert.assertEquals(actualMessage, expectedMessage,"Submission Error");
		Log.info("Verifed the success message: "+expectedMessage);
	}
	
	@Then("I enter the below values in the webpage")
	public void fill_WebPage(DataTable formData) {
		WebFromPage webPage= pageManager.getHomePage();	
		webPage.fill_formPageFields(formData);
	}
	
	@Then("I get the default value from the {string} field")
	public void getDefaultValue_WebPage(String fieldName) {
		WebFromPage webPage= pageManager.getHomePage();	
		String defaultValue = webPage.getValueFromField(fieldName);
		ExtentCucumberAdapter.addTestStepLog("Deafult value from the field "+fieldName+" is "+defaultValue);
	}
}
