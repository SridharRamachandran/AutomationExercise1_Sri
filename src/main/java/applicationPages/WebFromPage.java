package applicationPages;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.datatable.DataTable;
import utilities.SeleniumUtilities;
public class WebFromPage {
	
	private WebDriver driver;
	
	public WebFromPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="my-text-id")
	WebElement textInput_TextInputElement;	
	
	@FindBy(name="my-password")
	WebElement password_TextInputElement;
	
	@FindBy(name="my-select")
	WebElement mySelect_DropdownElement;
	
	@FindBy(name="my-datalist")
	WebElement myOptions_DatalistElement;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement submitButton;
	
	@FindBy(className="lead")
	WebElement formSubmitted_TextElement;	
	
	@FindBy(name="my-date")
	WebElement datePicker_Element;	
	
	@FindBy(name="my-readonly")
	WebElement readOnly_Element;	
	
	public void enterValue(String value, String fieldName ) {
		if(fieldName.equalsIgnoreCase("TextInput")) {
			SeleniumUtilities.sendKeys(textInput_TextInputElement, value);
		}
		if(fieldName.equalsIgnoreCase("Password")) {
			SeleniumUtilities.sendKeys(password_TextInputElement, value);
		}
		
		if(fieldName.equalsIgnoreCase("DataList")) {
			SeleniumUtilities.sendKeys(myOptions_DatalistElement, value);
		}
	}
	
	public void selectValue(String value, String dropdownName ) {
		if(dropdownName.equalsIgnoreCase("Select")) {
			SeleniumUtilities.select_ByVisibleText(driver,mySelect_DropdownElement, value);
		}
		
	}
	
	public void clickOnButton(String buttonName) {
		if(buttonName.equalsIgnoreCase("Submit")) {
			SeleniumUtilities.clickOnElement(submitButton);
		}
	}
	
	public String verifySuccessMessage() {
		String actualMessage=SeleniumUtilities.getTextFromWebElement(formSubmitted_TextElement);
		return actualMessage;
	}
	
	public void enterDate(String date) {		
			SeleniumUtilities.sendKeys(datePicker_Element,date);		
	}
	
	public String getValueFromField(String fieldName) {		
		String deafultValue=SeleniumUtilities.getAttributevalue(readOnly_Element,"value");
		return deafultValue;
}
	
	
	public void fill_formPageFields(DataTable table) {
		List<Map<String, String>> user = table.asMaps(String.class, String.class);
		System.out.println(user.get(0).get("TextInput"));
		SeleniumUtilities.sendKeys(textInput_TextInputElement, user.get(0).get("TextInput"));
		SeleniumUtilities.sendKeys(password_TextInputElement, user.get(0).get("password"));
		SeleniumUtilities.select_ByVisibleText(driver,mySelect_DropdownElement, user.get(0).get("SelectDropdown"));
		SeleniumUtilities.sendKeys(myOptions_DatalistElement, user.get(0).get("DataList"));
		this.enterDate(user.get(0).get("DatePicker"));
	}

}
