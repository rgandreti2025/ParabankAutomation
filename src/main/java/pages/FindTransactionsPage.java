package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class FindTransactionsPage {
	WebDriver driver;

	// Locate "Find Transactions" page title
	@FindBy(xpath = "///h1[@class='title']")
	private WebElement findTransactionsTitle;

	@FindBy(xpath = "//input[@id='transactionId']")
	private WebElement Find_Transaction_ID;

	@FindBy(xpath = "//input[@id='transactionDate']")
	private WebElement FindTransctionWithDate;

	@FindBy(xpath = "//input[@id='fromDate']")
	private WebElement FromDate;

	@FindBy(xpath = "//input[@id='toDate']")
	private WebElement ToDate;
	@FindBy(xpath = "//input[@id='amount']")
	private WebElement AmounttxtBox;

	@FindBy(xpath = "(//button[@type='submit'])[1]")
	private WebElement firstTranscationButton;

	@FindBy(xpath = "(//button[@type='submit'])[2]")
	private WebElement secondTranscationButton;
	@FindBy(xpath = "(//button[@type='submit'])[3]")
	private WebElement thirdTranscationButton;
	@FindBy(xpath = "(//button[@type='submit'])[4]")
	private WebElement fourthTranscationButton;

	// Locate the search result element (adjust this XPath if needed)
	@FindBy(xpath = "//table[contains(@class,'transaction')]//td")
	private WebElement transactionResult;

	// Locator for account dropdown
    private By accountDropdown = By.id("accountId");


	public FindTransactionsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Method to enter Transaction ID
	public void enterTransactionId(String transactionId) {
		Find_Transaction_ID.clear();
		Find_Transaction_ID.sendKeys(transactionId);
	}

	// Method to click the Find Transactions button
	public void clickFindTransaction() {
		firstTranscationButton.click();
	}

	// Method to fetch all available accounts
	public List<String> getAvailableAccounts() {
		WebElement dropdownElement = driver.findElement(accountDropdown);
		Select select = new Select(dropdownElement);
		List<WebElement> accountOptions = select.getOptions();

		List<String> accountNumbers = new ArrayList<>();
		for (WebElement option : accountOptions) {
			accountNumbers.add(option.getText().trim()); // Trim to avoid spaces
		}
		return accountNumbers;
	}

	// Method to select an account by its value
	public void selectAccountById(String accountId) {
		WebElement dropdownElement = driver.findElement(accountDropdown);
		Select select = new Select(dropdownElement);
		select.selectByValue(accountId); // Selects the account based on value
		System.out.println("Selected Account: " + accountId);
	}

	// Method to verify if "Find Transactions" page is displayed
	public boolean isFindTransactionsPageDisplayed() {
		return findTransactionsTitle.isDisplayed();
	}

	// Method to verify if transaction is displayed in search results
	public boolean isTransactionDisplayed(String transactionId) {
		try {
			return transactionResult.getText().contains(transactionId);
		} catch (Exception e) {
			return false; // Return false if element is not found
		}
	}
}
