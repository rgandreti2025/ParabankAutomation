package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BillPayPage {

	 protected WebDriver driver;

	    // Constructor
	    public BillPayPage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }
	    
	   @FindBy(xpath="//a[text()='Bill Pay']")
	    private WebElement billpaylink;
	   
	   
	   public void billpayclick() {
			  billpaylink.click();
	   }
	    
	    
}
