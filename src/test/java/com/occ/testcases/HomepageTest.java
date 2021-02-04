package com.occ.testcases;
import java.util.Map;

import org.assertj.core.api.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.occ.listeners.RetryFailedTests;
import com.occ.pages.homePage;
import com.occ.utils.DataProviderUtils;

public final class HomepageTest extends BaseTest{

	private HomepageTest(){
	}

	@Test(dataProvider="getData",dataProviderClass=DataProviderUtils.class,retryAnalyzer=RetryFailedTests.class)
		public void CreateAccountduplicateemail(Map<Object, Object> DataMap){
		System.out.println("Current thread is:: "+Thread.currentThread());
		boolean result=new homePage()
				.clickCreateAccount()
				.EnterAccountInfo(DataMap.get("FNAME").toString(), DataMap.get("LNAME").toString(), DataMap.get("EMAIL").toString(), DataMap.get("PHONE").toString(), DataMap.get("PASSWORD").toString(), DataMap.get("CONFIRMPASSWORD").toString()).logoutButtonExits();
		Assertions.assertThat(result)
		.isEqualTo(false);
	}

	@Test(dataProvider="getData",dataProviderClass=DataProviderUtils.class,retryAnalyzer=RetryFailedTests.class)
	public void CreateAccountIncorrectemail(Map<Object, Object> DataMap){
		System.out.println("Current thread s "+Thread.currentThread());
		boolean result=new homePage().clickCreateAccount().EnterAccountInfo(DataMap.get("FNAME").toString(), DataMap.get("LNAME").toString(), DataMap.get("EMAIL").toString(), DataMap.get("PHONE").toString(), DataMap.get("PASSWORD").toString(), DataMap.get("CONFIRMPASSWORD").toString()).logoutButtonExits();
		System.out.println("INC"+result);
		Assertions.assertThat(result)
		.isEqualTo(false);
	}

	@Test(dataProvider="getData",dataProviderClass=DataProviderUtils.class,retryAnalyzer=RetryFailedTests.class)
	public void CreateAccountBlankemail(Map<Object, Object> DataMap){
		boolean result=new homePage().clickCreateAccount().EnterAccountInfo(DataMap.get("FNAME").toString(), DataMap.get("LNAME").toString(), DataMap.get("EMAIL").toString(), DataMap.get("PHONE").toString(), DataMap.get("PASSWORD").toString(), DataMap.get("CONFIRMPASSWORD").toString()).logoutButtonExits();
		Assertions.assertThat(result)
		.isEqualTo(false);
	}

	@Test(dataProvider="getData",dataProviderClass=DataProviderUtils.class,retryAnalyzer=RetryFailedTests.class)
	public void CreateAccountemail(Map<Object, Object> DataMap){
		boolean result=new homePage().clickCreateAccount().EnterAccountInfo(DataMap.get("FNAME").toString(), DataMap.get("LNAME").toString(), DataMap.get("EMAIL").toString(), DataMap.get("PHONE").toString(), DataMap.get("PASSWORD").toString(), DataMap.get("CONFIRMPASSWORD").toString()).logoutButtonExits();
		Assertions.assertThat(result)
		.isEqualTo(true);
	}

	@DataProvider(name="MyDatatest", parallel=true)
	public Object[][] loginData(){
		return new Object[][]{
			{"Dummy1","Dummy2","dg167j2d@aol.com","1234567890","qwerty123","qwerty123"}
		};

	}

}
