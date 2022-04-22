package com.e2x.luma.cucumber;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Hooks {

    public static WebDriver driver;

    @Before
    public void beforeScenario() throws IOException {
        //Load Properties file
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("src//test//resources//properties//env.properties");
        prop.load(fis);

        //Get Target Browser
        if(prop.getProperty("targetBrowser").equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }else if (prop.getProperty("targetBrowser").equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
        }

        //launch target URL loaded in properties file
        driver.get(prop.getProperty("targetURL"));
    }

    @After
    public void afterScenario(){
        driver.quit();
    }


}
