package com.occ.driver;

import org.openqa.selenium.WebDriver;

public final class DriverManager {
	
	private DriverManager(){
		
	}

	private static ThreadLocal<WebDriver> dr= new ThreadLocal<>();

	public static WebDriver getDriver(){
		System.out.println("(Driver Manager GET METHOD )Current thread is : "+Thread.currentThread());
		return dr.get();
	}

	public static void setDriver(WebDriver driverf){
		System.out.println("(Driver Manager SETUP METHOD )Current thread is : "+Thread.currentThread());
		dr.set(driverf);
	}

	public static void unload(){
		System.out.println("(Driver Manager Unload METHOD )Current thread is : "+Thread.currentThread());
		dr.remove();
	}

}
