package Mouse_Actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Language_page {
	
       @FindBy (xpath ="(//div[text()='Change country/region.'])[1]") 
	  private WebElement change ;
	 
	 private WebDriver driver;
	 
	 public Language_page (WebDriver driver) {
			PageFactory.initElements(driver, this);
			 this.driver= driver;
		  }
	 
	 public void clickonchange() {
		
		 Actions act = new Actions(driver);
		act.moveToElement(change).click().build().perform();
	  }
}
