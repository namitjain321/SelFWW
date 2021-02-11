package com.occ.factories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public final class DriverFactory {

	private DriverFactory(){
		
	}
	//static WebDriver driver;
	public static WebDriver DriverRetrun(String BrowserName){
		System.out.println("(Driver factory class driver return METHOD )Current thread is : "+Thread.currentThread());
		WebDriver driver=null;
		if(BrowserName.equalsIgnoreCase("firefox")){
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