package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utilities.BaseTest;
import utilities.JsonReader;

public class LoginTest extends BaseTest {

    @Test
    public void testValidLogin() {
        String username = JsonReader.getValue("validUser", "username");
        String password = JsonReader.getValue("validUser", "password");

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = loginPage.login(username, password);

        // Validate login success
        Assert.assertTrue(homePage.isLoginSuccessful(), "Login Failed!");
    }

    @Test
      public void testInvalidLogin() {
        String username = JsonReader.getValue("invalidUser", "username");
        String password = JsonReader.getValue("invalidUser", "password");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);

        // Validate login failure message
        Assert.assertTrue(loginPage.isLoginErrorDisplayed(), "Expected login failure but succeeded!");
    }
}
