package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FindTransactionsPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.BaseTest;

public class FindTransactionsTest extends BaseTest {

	@Test
	public void testFindTransactionsNavigation() {
		// ✅ Step 1: Login
		LoginPage loginPage = new LoginPage(driver);
		HomePage homePage = loginPage.login("john", "demo");

		// ✅ Step 2: Click on "Find Transactions"
		FindTransactionsPage findTransactionsPage = homePage.goToFindTransactionsPage();

		// ✅ Step 3: Verify "Find Transactions" page is displayed
		Assert.assertTrue(findTransactionsPage.isFindTransactionsPageDisplayed(),
				"Find Transactions page is not displayed!");
	}
}
