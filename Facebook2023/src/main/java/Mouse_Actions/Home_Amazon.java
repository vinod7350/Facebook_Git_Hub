package Mouse_Actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_Amazon {

	 @FindBy (xpath ="//span[@class='nav-line-2']") 
	  private WebElement lang ;
	  
	  private WebDriver driver;
	  private Actions act;
	  public Home_Amazon (WebDriver driver) {
		PageFactory.initElements(driver, this);
		 this.driver= driver;
		 act =new Actions(this.driver);
		 //or
	//	 act =new Actions(driver);
 
	  }
	  
	  public void clickonlang() {
	//	 Actions act = new Actions(driver);
		 act.moveToElement(lang).perform();
	  }
  }
