package TestNG;

import static org.testng.Assert.fail;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import POM_Classes.NewAccCreation;
import POM_Classes.SignUPPage;
import Utils.Utility;

public class FacebookTestNG {
	
	//declared globally
	WebDriver driver;
	SignUPPage signUPPage;
	NewAccCreation newAccCreation;
	String testID;


	@Parameters ("browser")
	@BeforeTest
	public void launchbrowser(String browserName) {
		
	   System.out.println(browserName);
	   
	  if(browserName.equals("Chrome"))
	  {
         System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Downloads\\chromedriver.exe3");
	     driver=new ChromeDriver();// object to call get method  
	  } 
	  if(browserName.equals("Firefox"))
	  {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\HP\\Downloads\\geckodriver.exe");
	    driver=new FirefoxDriver();// object to call get method  
	  }
	
	}
	
	@BeforeClass
	public void ObjectStore() {
		System.out.println("Before Class");
		
	signUPPage = new SignUPPage(driver);

	 newAccCreation=new NewAccCreation (driver);


	}
	@BeforeMethod
	public void launchApplication() throws EncryptedDocumentException, IOException {
		System.out.println("BeforeMethod");
		
		driver.get("https:www.facebook.com");
		driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	
	}
   
	@Test (priority=1)
	public void test1() throws EncryptedDocumentException, IOException {
    testID=" AQ23 ";
    System.out.println("fail test 1");
    
    
    
	}
	@Test (priority=0)
	public void test() throws EncryptedDocumentException, IOException {
		System.out.println("fail test 2");
		testID="ABC13";
		
		signUPPage.clickoncreateNewAcc();

	    String data=Utility.getDataFromexcelSheet("vinod", 3,0);
		newAccCreation.sendfName(data);
		
		String data1 =Utility.getDataFromexcelSheet("vinod", 3,1);
		newAccCreation.sendlName(data1);
		String data2 =Utility.getDataFromexcelSheet("vinod", 3,2);

		newAccCreation.sendmobNo(data2);
		newAccCreation.sendpass();
		newAccCreation.selectDay();
		newAccCreation.selectMonth();
		newAccCreation.selectYear();
		newAccCreation.clickOnMale();
	}
 	@AfterMethod
	public  void aftermethod(ITestResult result) throws IOException {
		System.out.println("after method");
		
		if(ITestResult.FAILURE==result.getStatus())
		{
			System.out.println("Print Failure");
			Utility.captureScreenShot(driver,testID );
		}
		
	}
	
	@AfterClass
	public void afterclass() {
		System.out.println("after class");
		WebDriver driver=null;
		SignUPPage signUPPage=null;
		NewAccCreation newAccCreation=null;
	}
	@AfterTest
	public void afterTest() {
		System.out.println("afterTest");
	//	driver.close();

	}
}
