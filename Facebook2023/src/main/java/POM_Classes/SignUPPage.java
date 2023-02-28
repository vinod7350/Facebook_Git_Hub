package POM_Classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUPPage {
	 @FindBy (xpath ="//a[text()='Create new account']") 
	  private WebElement createNewAcc ;
	 
      private WebDriver driver;
      
	  public SignUPPage (WebDriver driver) {
		  PageFactory.initElements(driver, this);
		  this.driver=driver;
	  }
	  
	  
	  public void clickoncreateNewAcc() {
		  WebDriverWait wait = new WebDriverWait(driver,10);
		 wait.until(ExpectedConditions.visibilityOf(createNewAcc));
		  createNewAcc.click();
	  }
		  
	
}
