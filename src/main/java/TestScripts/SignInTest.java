package TestScripts;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import PageObject.SignInPage;
import Utility.Constants;

public class SignInTest {

	SignInPage signIn;

	@BeforeTest
	public void setUp() {
		try {
			signIn = new SignInPage();
		} catch (Exception e) {
			e.printStackTrace();
		}
		signIn.goTo(Constants.baseUrl);
	}

	@Test
	public void shouldThrowAnErrorIfSignInDetailsAreMissing() throws Exception {

		signIn.clickOnYourTripLink();
		signIn.clickOnSignIn();
		signIn.clickOnSignInButton();
		System.out.println("Error text: " + signIn.getErrorString());
		Assert.assertTrue(signIn.getErrorString().contains("There were errors in your submission"));

	}

	@AfterTest
	public void tearDown() {
		signIn.closePage();
	}

}
