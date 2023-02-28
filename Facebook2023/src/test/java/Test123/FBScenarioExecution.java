package Test123;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import FBScenario.FBHomePage;
import FBScenario.FBSignUpForm;

public class FBScenarioExecution {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Downloads\\chromedriver.exe3");	
		WebDriver driver = new ChromeDriver();
		driver.get("https:www.facebook.com");
		driver.manage().timeouts().implicitlyWait(8,TimeUnit.SECONDS);
	  
		FBHomePage fBHomePage =new FBHomePage(driver);
		Thread.sleep(3000);

		fBHomePage.clickoncreateNewAcc();
		Thread.sleep(3000);
		
		FBSignUpForm fBSignUpForm =new FBSignUpForm(driver);
		fBSignUpForm.clickOnTerm();
		Thread.sleep(5);
	
	    String url=	driver.getTitle();
	    
	    System.out.println(url);
	    
	    if(url.equals("Facebook – log in or sign up"))
	    {
	    	System.out.println("url vveificaton done==pass");
	    }
	    else
	    {
	    	System.out.println("url vveificaton fail");

	    }
	    
	 	ArrayList<String> child = new ArrayList<String>(driver.getWindowHandles() );
	 	driver.switchTo().window(child.get(0));
//	    driver.navigate().back();
	    

//	 	fBSignUpForm.clickOnPrivacyPolicy();
//	    Thread.sleep(5);
//        String url1=	driver.getTitle();
//	    
//	    System.out.println(url1);
//	    
//	    if(url1.equals("Facebook – log in or sign up"))
//	    {
//	    	System.out.println("url1 vveificaton done==pass");
//	    }
//	    else
//	    {
//	    	System.out.println("url1 vveificaton fail");
//
//	    }
//	    
//	 	ArrayList<String> child1 = new ArrayList<String>(driver.getWindowHandles() );
//	    driver.switchTo().window(child1.get(0));
// 	fBSignUpForm.clickOncookiesPolicy();
// 	
//	 	String url2=	driver.getTitle();
//	    System.out.println(url2);
//	    if(url1.equals("Facebook – log in or sign up"))
//	    {
//	    	System.out.println("url2 vveificaton done==pass");
//	    }
//	    else
//	    {
//	    	System.out.println("url2 vveificaton fail");
//
//	    }

//	 	String url2=	driver.getTitle();
//	    System.out.println(url2);
//	    driver.close();
	   
		
	}
}
