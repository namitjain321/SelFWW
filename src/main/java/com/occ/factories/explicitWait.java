package com.occ.factories;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.occ.constants.FrameworkConstants;
import com.occ.driver.DriverManager;
import com.occ.enums.waitStrategy;

public class explicitWait {

	public static WebElement performExplicitWait(By element,waitStrategy WaitStrategy){
		WebElement ElementReturned=null;
		if(WaitStrategy==WaitStrategy.CLICKABLE){
			ElementReturned=new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplcitwait()).until(ExpectedConditions.elementToBeClickable(element));
		}
		else if(WaitStrategy==WaitStrategy.PRESENCE){
			ElementReturned=new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplcitwait()).until(ExpectedConditions.visibilityOfElementLocated(element));
			return ElementReturned;
		}
		else if (WaitStrategy==WaitStrategy.NONE){
			ElementReturned=DriverManager.getDriver().findElement(element);
		}
		return ElementReturned;

	}
}
