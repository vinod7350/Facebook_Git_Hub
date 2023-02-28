package FBScenario;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FBHomePage {

	 @FindBy (xpath ="//a[text()='Create new account']") 
	  private WebElement createNewAcc ;
     
	  public FBHomePage (WebDriver driver) {
		  PageFactory.initElements(driver, this);
	  }
	  
	  public void clickoncreateNewAcc() {
		  
		  createNewAcc.click();
	  }
	  
 public String getcreateNewAccText() {
		  
	String data= createNewAcc.getText(); 
	 return data ;
	  }
		  
	
}
