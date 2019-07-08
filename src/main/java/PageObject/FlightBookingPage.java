package PageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import DriverMgmt.DriverFactory;
import Exceptions.DriverException;

public class FlightBookingPage {
	private WebDriver driver;
	private WebDriverWait wait;

	@FindBy(linkText = "Flights")
	WebElement FlightsTab;

	@FindBy(id = "OneWay")
	WebElement OneWayRadioBtn;

	@FindBy(id = "FromTag")
	WebElement From;

	@FindBy(css = "#ui-id-1 li:nth-child(1)")
	WebElement FromList;

	@FindBy(id = "ToTag")
	WebElement To;

	@FindBy(css = "#ui-id-2 li:nth-child(1)")
	WebElement ToList;

	@FindBy(id = "DepartDate")
	WebElement DepartDate;

	@FindBy(xpath = "(//td[@data-handler='selectDay'])[1]")
	WebElement ValidDate;

	@FindBy(id = "SearchBtn")
	WebElement SearchButton;

	@FindBy(className = "searchSummary")
	WebElement searchSummary;

	public FlightBookingPage() throws Exception {
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

	public void clickOnOneWayRadioBtn() {
		wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(OneWayRadioBtn));
		OneWayRadioBtn.click();
	}

	public void clearFromSearchBox() {
		From.clear();
	}

	public void enterLocationInFromSearchBox(String fromLocation) {
		wait = new WebDriverWait(driver, 4);
		wait.until(ExpectedConditions.visibilityOf(From));
		From.sendKeys(fromLocation);
		try { // added so that the execution can pause for list to load
			Thread.sleep(9000);
		} catch (Exception e) {
		}
	}

	public void clickAndClearFromSearchBox() {
		From.click();
		From.sendKeys(Keys.DELETE);
	}

	public void selectLocationFromSearchBoxSuggestion() {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(FromList));
		FromList.click();
	}

	public void clearToSearchBox() {
		wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(To));
		To.clear();
	}

	public void enterLocationInToSearchBox(String toLoaction) {
		To.sendKeys(toLoaction);
	}

	public void selectLocationInToSearchBoxSuggestion() {
		wait = new WebDriverWait(driver, 8);
		wait.until(ExpectedConditions.visibilityOf(ToList));
		ToList.click();
	}

	public void clickDepartDate() {
		wait = new WebDriverWait(driver, 8);
		wait.until(ExpectedConditions.visibilityOf(DepartDate));
		DepartDate.click();
	}

	public void selectDate() { //will always select the first valid date
		wait = new WebDriverWait(driver, 8);
		wait.until(ExpectedConditions.visibilityOf(ValidDate));
		ValidDate.click();
	}

	public void clickOnSearchBtn() {
		wait = new WebDriverWait(driver, 8);
		wait.until(ExpectedConditions.visibilityOf(SearchButton));
		SearchButton.click();
	}

	public boolean checkSearchResult() {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(searchSummary));
		return searchSummary.isDisplayed();
	}

	public void closeFlightBookingPage() {
		driver.quit();
	}
}
