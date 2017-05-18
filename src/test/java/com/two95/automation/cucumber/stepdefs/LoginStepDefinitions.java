package com.two95.automation.cucumber.stepdefs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginStepDefinitions {
	
	public static WebDriver driver;
	static Configuration config;
	public LoginStepDefinitions() {
		driver = CucumberHook.driver;
		config=CucumberHook.config;
	}
	
	@Given("^User is on Home Page$")
	public void User_is_on_Home_Page() throws Throwable {
        driver.get(config.getUrl());
	}

	@When("^User Navigate to LogIn Page$")
	public void User_Navigate_to_LogIn_Page() throws Throwable {
		driver.findElement(By.xpath(".//*[@id='account']/a")).click();
	}

	@When("^User enters UserName and Password$")
	public void User_enters_UserName_and_Password() throws Throwable {
		User testUser1 = config.getUsers().get("user1");
		driver.findElement(By.id("log")).sendKeys(testUser1.getName()); 	 
	    driver.findElement(By.id("pwd")).sendKeys(testUser1.getPass());
	    driver.findElement(By.id("login")).click();
	}

	@Then("^Message displayed Login Successfully$")
	public void Message_displayed_Login_Successfully() throws Throwable {
		//TODO validate by checking an element on the screen
		System.out.println("Login Successfully");
	}

	@When("^User LogOut from the Application$")
	public void User_LogOut_from_the_Application() throws Throwable {
		driver.findElement (By.xpath(".//*[@id='account_logout']/a")).click();
	}

	@Then("^Message displayed LogOut Successfully$")
	public void Message_displayed_LogOut_Successfully() throws Throwable {
		//TODO validate by checking an element on the screen
		System.out.println("LogOut Successfully");
	}


}
