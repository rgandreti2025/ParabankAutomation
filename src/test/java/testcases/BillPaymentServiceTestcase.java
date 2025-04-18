package testcases;

import utilities.BaseTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utilities.BaseTest;
import utilities.TestDataUtil;

public class BillPaymentServiceTestcase extends BaseTest{
		
	@Test
	
	public void billpayment() {
		//clicking on bill pay link
		String username = TestDataUtil.getUsername();
		String password = TestDataUtil.getPassword();
		LoginPage loginPage = new LoginPage(driver);
       	HomePage homePage = loginPage.login(username, password);
		  // Validate login success
        Assert.assertTrue(homePage.isLoginSuccessful(), "Login Passed");
	}
	
	
	

}
