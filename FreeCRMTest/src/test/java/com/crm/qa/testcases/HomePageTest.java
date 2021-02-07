package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;



public class HomePageTest extends TestBase{
	
	LoginPage loginpage;
	HomePage homePage;	
	ContactsPage contactsPage;
	DealsPage dealsPage;

	
	public HomePageTest()
	{
		super();
		
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginpage=new LoginPage();
		contactsPage=new ContactsPage();
		dealsPage=new DealsPage();
		homePage=loginpage.Login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority = 1)
	public void homepageTitleTest()
	{
		String homepageTitle=homePage.getHomePageTitle();
		Assert.assertEquals(homepageTitle,"Cogmento CRM","homepage title not matching");
	}
	@Test(priority = 2)
	public void loggedinUserTest()
	{
		String loggedinUser=homePage.getLoggedinUser();
		Assert.assertEquals(loggedinUser,"Chandra Tivari","loggedin user does not match");
	}
	@Test(priority = 3)
	public void contactClickTest()
	{
		contactsPage=homePage.clickonContactLink();			
		
	}
	@Test(priority = 4)
	public void dealsClickTest()
	{
		dealsPage=homePage.clickonDealsLink();
		Assert.assertTrue(dealsPage.VerifyDealsPageTitle().contains("Deals"));
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();		
	}
	

}
