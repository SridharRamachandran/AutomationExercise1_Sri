package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
features = "src/test/resources/features",
glue = ("stepDefinitions"),
tags=("@WebFormPage1 or @WebFormPage2"),
dryRun = false,
monochrome = true,
plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
		"pretty","io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}
)

public class TestRunner extends AbstractTestNGCucumberTests {

}
