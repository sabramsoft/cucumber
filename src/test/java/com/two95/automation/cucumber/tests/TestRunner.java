package com.two95.automation.cucumber.tests;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features"
		,glue={"com.two95.automation.cucumber.stepdefs"},
		monochrome=true,
		format = {"pretty",
				"html:target/TestLogin",
				"json:target/json/test-login.json",
				"junit:target/junit/test-login.xml"}
		)

public class TestRunner {

}
