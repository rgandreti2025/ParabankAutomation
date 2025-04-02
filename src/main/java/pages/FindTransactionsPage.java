package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FindTransactionsPage {
	WebDriver driver;

	// Locate "Find Transactions" page title
	@FindBy(xpath = "//h1[contains(text(),'Find Transactions')]")
	private WebElement findTransactionsTitle;

	public FindTransactionsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Verify if "Find Transactions" page is displayed
	public boolean isFindTransactionsPageDisplayed() {
		return findTransactionsTitle.isDisplayed();
	}
}
