package com.occ.factories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	//static WebDriver driver;
	public static WebDriver DriverRetrun(String BrowserName){
		WebDriver driver=null;
		if(BrowserName.equalsIgnoreCase("firefox")){
				System.out.println("INSIDE FF");
				WebDriverManager.firefoxdriver().setup();
				driver=new FirefoxDriver();
			}
			else if(BrowserName.equalsIgnoreCase("chrome")){
				WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver();
			}
			return driver;
	}

}