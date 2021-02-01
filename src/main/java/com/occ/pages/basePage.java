package com.occ.pages;

import org.openqa.selenium.By;

import com.occ.driver.DriverManager;
import com.occ.enums.waitStrategy;
import com.occ.factories.explicitWait;
import com.occ.reports.ExtentLogger;

public class basePage {

	protected void click(By element, waitStrategy WaitCondition, String ElementName){
		explicitWait.performExplicitWait(element,WaitCondition).click();
		//ExtentLogger.Pass(ElementName+" is clicked");
		try {
			ExtentLogger.Pass(ElementName+" is clicked",true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void enterText(By element, String text,waitStrategy WaitCondition, String ElementName){
		explicitWait.performExplicitWait(element,WaitCondition).sendKeys(text);
		//ExtentLogger.Pass("Text entered in "+ElementName+ " field");
		try {
			ExtentLogger.Pass(ElementName+" is clicked",true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected boolean ObjectExists(By element){
		try {
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			DriverManager.getDriver().findElement(element).click();
				return true;

		} catch (org.openqa.selenium.ElementNotInteractableException e) {
			return false;
		}
		catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}

	}
}