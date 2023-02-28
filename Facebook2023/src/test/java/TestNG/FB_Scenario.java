package TestNG;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import FBScenario.FBHomePage;
import FBScenario.FBSignUpForm;
import Utils.Utility;

public class FB_Scenario {

	WebDriver driver;
	FBHomePage fBHomePage;
	FBSignUpForm fBSignUpForm;
	String testID ; 

	@BeforeTest
	public void beforeTest() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Downloads\\chromedriver.exe3");	
	}
	
	
	
	@BeforeClass
	public void storeObject() {
		
		System.out.println("Before Class");
		
		 driver = new ChromeDriver();
         fBHomePage =new FBHomePage(driver);
 		 fBSignUpForm =new FBSignUpForm(driver);

	
	}

	@BeforeMethod
	public void beforeMethod() throws InterruptedException {
		System.out.println("BeforeMethod");
		Thread.sleep(5000);
		driver.get("https:www.facebook.com");
		driver.manage().timeouts().implicitlyWait(8,TimeUnit.SECONDS);
	}
	
	@Test 
	public void test() throws InterruptedException {
	    System.out.println("=============");

		System.out.println("test");
		
		testID ="TC001";
		fBHomePage.clickoncreateNewAcc();
		Thread.sleep(3000);
		
		fBSignUpForm.clickOnTerm();
		ArrayList<String> child = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(child.get(1));
			
		// String url=	driver.getTitle();
	   String url=  driver.getCurrentUrl();
	   
	    System.out.println(url);
	    if(url.equals("https://www.facebook.com/legal/terms/update"))
	    {
	    	System.out.println("url vveificaton done");
	    }
	    else
	    {
	    	System.out.println("url vveificaton fail");

	    }
	driver.close();
	}

	@Test(priority= 1)
	public void test1() throws InterruptedException {
	    System.out.println("=============");

		System.out.println("test1");
		testID ="TC002";

	fBHomePage.clickoncreateNewAcc();
		Thread.sleep(3000);
		
	 	fBSignUpForm.clickOncookiesPolicy();
	 	ArrayList<String> child = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(child.get(1));
			
	 	String url1 =	driver.getCurrentUrl();
	    System.out.println(url1);

		if(url1.equals("https://www.facebook.com/privacy/policies/cookies/?entry_point=cookie_policy_redirect&entry=0"
				+ ""))
	    {
	    	System.out.println("url1 vveificaton done");
	    }
	    else
	    {
	    	System.out.println("url1 vveificaton fail");

	    }
		driver.close();

	}
	@Test(priority= 3 )
	public void test2() throws InterruptedException {
		System.out.println("============");
	     System.out.println("test 2");
			testID ="TC003";

	     SoftAssert soft = new SoftAssert();
	     fBHomePage.clickoncreateNewAcc();
	     Thread.sleep(3000);
	     
	  String actualtext = fBHomePage.getcreateNewAccText();
	  System.out.println(actualtext);
	  String expectedtext="cretenewaccout123";
	  soft.assertEquals(actualtext, expectedtext,"Get text is pass or fail");
	  
		fBSignUpForm.clickOnPrivacyPolicy();
		ArrayList<String> child = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(child.get(1));
			
	 	String url2 =	driver.getCurrentUrl();
	    System.out.println(url2);
	    
		if(url2.equals("Meta Privacy Policy – How Meta collects and uses user data"))
	    {
	    	System.out.println("url2 vveificaton done");
	    }
	    else
	    {
	    	System.out.println("url2 vveificaton fail");

	    }
		  soft.assertAll();

	}
	
	@AfterMethod
	public  void aftermethod(ITestResult result) throws IOException, InterruptedException {
		System.out.println("after method");
		
		if(ITestResult.FAILURE==result.getStatus())
		{
			System.out.println("Print Failure");
			Utility.captureScreenShot(driver,testID );
		}
		
		Thread.sleep(3000);
		ArrayList<String> child = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(child.get(0));
			
	}
	
	@AfterClass
	public void afterclass() {
		System.out.println("after class");
		
		WebDriver driver=null;
		FBHomePage fBHomePage=null;
		FBSignUpForm fBSignUpForm=null;
		
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("afterTest");
		driver.quit();

	}
	
	
}
