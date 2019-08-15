package com.kk.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WbDrvrMgrDemo {

	@Test
    public void WebDriverManagerTest()
    {
        //setup the chromedriver using WebDriverManager
        WebDriverManager.chromedriver().setup();
 
        //Create driver object for Chrome
        WebDriver driver = new ChromeDriver();
 
        //Navigate to a URL
        driver.get("http://toolsqa.com");
 
        //quit the browser
//        driver.quit();
    }

}
