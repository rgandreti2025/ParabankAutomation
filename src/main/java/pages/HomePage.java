package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;

	@FindBy(xpath = "//a[text()='Log Out']") // Logout button locator
	private WebElement logoutButton;
	
	// Find Transaction
	@FindBy(xpath = "//a[text()='Find Transactions']")
	private WebElement FindTransactionsLink;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Logout method that returns LoginPage
	public LoginPage logout() {
		logoutButton.click();
		return new LoginPage(driver); // After logout, user lands on LoginPage
	}

	public FindTransactionsPage goToFindTransactionsPage() {
		FindTransactionsLink.click();
		return new FindTransactionsPage(driver);
	}

	// Verify successful login (Logout button should be visible)
	public boolean isLoginSuccessful() {
		return logoutButton.isDisplayed();
	}
}
