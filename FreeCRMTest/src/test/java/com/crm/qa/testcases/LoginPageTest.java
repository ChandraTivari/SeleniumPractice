package com.crm.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;


public class LoginPageTest extends TestBase{

	LoginPage loginpage;
	HomePage homePage;
	Logger log;

	public LoginPageTest()
	{
		super();
	}

	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginpage=new LoginPage();
		log=Logger.getLogger(LoginPageTest.class);
	}

	@Test(priority=1)	
	public void LoginPageTitleTest()
	{
		log.info("Start of the LoginPageTitleTest");
		String title=loginpage.validateLoginTitle();
		Assert.assertEquals(title, "Cogmento CRM11"); 
		log.info("End of the LoginPageTitleTest");

	}
	@Test(priority=2)
	public void LoginTest()
	{
		log.info("Start of the LoginTest");
		homePage=loginpage.Login(prop.getProperty("username"), prop.getProperty("password"));
		String hTitle=homePage.getHomePageTitle();
		Assert.assertEquals(hTitle, "Cogmento CRM");
		log.info("End of the LoginTest");
	}

	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
}
