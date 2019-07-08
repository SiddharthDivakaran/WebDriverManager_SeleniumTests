package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import DriverMgmt.DriverFactory;
import Exceptions.DriverException;

public class SignInPage {

	private WebDriver driver;
	private WebDriverWait wait;

	@FindBy(linkText = "Your trips")
	private WebElement Your_Trips_Link;

	@FindBy(id = "SignIn")
	private WebElement Sign_In;

	@FindBy(id = "modal_window")
	private WebElement FrameId;

	@FindBy(id = "signInButton")
	private WebElement SignIn_Button;

	@FindBy(id = "errors1")
	private WebElement Errors;

	public SignInPage() throws Exception {
		try {
			driver = DriverFactory.getDriverInstance(DriverFactory.CHROME);
			PageFactory.initElements(driver, this);
		} catch (DriverException e) {
			e.printStackTrace();
		}
	}

	public void goTo(String url) {
		driver.get(url);
	}

	public void clickOnYourTripLink() {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(Your_Trips_Link));
		Your_Trips_Link.click();
	}

	public void clickOnSignIn() {
		Sign_In.click();
	}

	public void clickOnSignInButton() {
		driver.switchTo().frame(FrameId);
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(SignIn_Button));
		SignIn_Button.click();
	}

	public String getErrorString() {
		return Errors.getText();
	}

	public void closePage() {
		driver.quit();
	}

}
