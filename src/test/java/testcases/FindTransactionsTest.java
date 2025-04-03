package testcases;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FindTransactionsPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.BaseTest;
import utilities.JsonReader;
import utilities.TestDataUtil;

public class FindTransactionsTest extends BaseTest {

	@Test
	public void testFindTransactionsNavigation() {
		// Step 1: Login
		String username = TestDataUtil.getUsername();
		String password = TestDataUtil.getPassword();
		LoginPage loginPage = new LoginPage(driver);
		HomePage homePage = loginPage.login(username, password);

		// Step 2: Click on "Find Transactions"
		FindTransactionsPage findTransactionsPage = homePage.goToFindTransactionsPage();

		// Step 3: Verify "Find Transactions" page is displayed
		Assert.assertTrue(findTransactionsPage.isFindTransactionsPageDisplayed(),
				"Find Transactions page is not displayed!");
	}

	@Test

	public void Check_Transaction_ID() {
		// checking with transaction id
		// Step 1: Enter a Transaction ID and Search
		String username = TestDataUtil.getUsername();
		String password = TestDataUtil.getPassword();
		String transactionId = TestDataUtil.getTransactionId();
		// Step 3: Login
		LoginPage loginPage = new LoginPage(driver);
		HomePage homePage = loginPage.login(username, password);
		// Step 4: Navigate to Find Transactions Page
		FindTransactionsPage findTransactionsPage = homePage.goToFindTransactionsPage();

		// Step 5: Enter Transaction ID and Search
		findTransactionsPage.getAvailableAccounts();
		findTransactionsPage.enterTransactionId(transactionId);
		findTransactionsPage.clickFindTransaction();

		// Step 6: Validate the Transaction is Found
		Assert.assertTrue(findTransactionsPage.isTransactionDisplayed(transactionId), "Transaction Not Found!");

	}

	@Test
	public void verifyAccountExistsAndSelectIt() {
		// Read expected account from JSON
		String expectedAccountId = JsonReader.getValue("transaction", "expectedAccountId");

		// Navigate to Find Transactions Page
		FindTransactionsPage findTransactionsPage = new FindTransactionsPage(driver);
		// all accounts
		List<String> availableAccounts = findTransactionsPage.getAvailableAccounts();
		// Print for debugging
		System.out.println("Available Accounts: " + availableAccounts);
		// Validate the account exists
		Assert.assertTrue(availableAccounts.contains(expectedAccountId),
				"Account ID " + expectedAccountId + " is not found in the dropdown!");
		// Select the account
		findTransactionsPage.selectAccountById(expectedAccountId);
	}
}
