package com.two95.automation.cucumber.stepdefs;
import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class CucumberHook {
	
	private static final ObjectMapper MAPPER = new ObjectMapper(new YAMLFactory());
	public static Configuration config;
	public CucumberHook () {

        Configuration conf = null;
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            File file = new File(classLoader.getResource("config.yml").getFile());
            conf = MAPPER.readValue(file, Configuration.class);
            System.out.println("Current config\n{}\n"+conf.toString());
        } catch (Exception e) {
            System.err.println(""+e);
        }
        config = conf;
    
	}
	
	public static WebDriver driver;
	@Before
	public void setup() {
		File file = new File("C:/selenium/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
		driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@After
	public void destroy() {
		if(driver!=null) {
			driver.quit();
		}
	}

}
