package com.occ.pages;
import org.openqa.selenium.By;

import com.occ.enums.waitStrategy;

public class homePage extends basePage {

	private final By btnCreateAccount=By.id("CC-loginHeader-registration");
	private final By fldFirstName=By.id("CC-userRegistration-firstname");
	private final By fldLastName=By.id("CC-userRegistration-lastname");
	private final By fldPhone=By.id("CC-userRegistration-phoneNumber");
	private final By fldEmail=By.id("CC-userRegistration-emailAddress");
	private final By fldPassword=By.id("CC-userRegistration-password");
	private final By fldConfirmPassword=By.id("CC-userRegistration-confirmPassword");
	private final By btnSubmitAccount=By.id("CC-userRegistrationSubmit");
	private final By linkLogout=By.id("CC-loginHeader-logout");
	//private final By myAccount=By.id("CC-loginHeader-myAccount");
	//Methods go here
	public homePage clickCreateAccount(){
		
		click(btnCreateAccount,waitStrategy.CLICKABLE, "CreateAccountButton");
		return this;
	}
	
	public homePage EnterAccountInfo(String Fname, String Lname, String Email, String Phone, String Password, String ConfirmPwd){
		enterText(fldFirstName, Fname,waitStrategy.PRESENCE, "FirstName");
		enterText(fldLastName, Lname,waitStrategy.PRESENCE, "LastName");
		enterText(fldPhone, Phone,waitStrategy.PRESENCE,"Phone" );
		enterText(fldEmail, Email,waitStrategy.PRESENCE, "Email");
		enterText(fldPassword, Password,waitStrategy.PRESENCE, "Password");
		enterText(fldConfirmPassword, ConfirmPwd,waitStrategy.PRESENCE, "Confirm Password");
		click(btnSubmitAccount,waitStrategy.CLICKABLE, "Submit Button");
		return this;
	}

	public boolean logoutButtonExits(){
		return ObjectExists(linkLogout);
	}
}