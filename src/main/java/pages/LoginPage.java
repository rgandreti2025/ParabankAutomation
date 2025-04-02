package pages; // Ensure this matches the folder structure

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;

	@FindBy(name = "username")
	private WebElement usernameField;

	@FindBy(name = "password")
	private WebElement passwordField;

	@FindBy(xpath = "//input[@value='Log In']")
	private WebElement loginButton;

	// ✅ Corrected locator for error message
	@FindBy(className = "error") // Update this based on your actual HTML
	private WebElement loginErrorMessage;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enterUsername(String username) {
		usernameField.sendKeys(username);
	}

	public void enterPassword(String password) {
		passwordField.sendKeys(password);
	}

	public void clickLogin() {
		loginButton.click();
	}

	public HomePage login(String username, String password) {
		enterUsername(username);
		enterPassword(password);
		clickLogin();
		return new HomePage(driver);
	}

	// Check if login error is displayed
	public boolean isLoginErrorDisplayed() {
		try {
			return loginErrorMessage.isDisplayed();
		} catch (Exception e) {
			return false; // Return false if the element is not found
		}
	}

}
