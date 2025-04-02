package testcases;


import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utilities.BaseTest;
import utilities.JsonReader;

public class LogoutTest extends BaseTest {

    @Test
    public void testLogout() {
        // ✅ Step 1: Login first
        String username = JsonReader.getValue("validUser", "username");
        String password = JsonReader.getValue("validUser", "password");
        
        // ✅ Perform Login using JSON data
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = loginPage.login(username, password);

        // ✅ Step 2: Verify login was successful
        Assert.assertTrue(homePage.isLoginSuccessful(), "Login Failed!");

        // ✅ Step 3: Logout
        loginPage = homePage.logout();

         }
}
