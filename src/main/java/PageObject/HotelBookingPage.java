package PageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import DriverMgmt.DriverFactory;
import Exceptions.DriverException;

public class HotelBookingPage {

	private WebDriver driver;
	private WebDriverWait wait;

	@FindBy(linkText = "Hotels")
	private WebElement hotelLink;

	@FindBy(id = "Tags")
	private WebElement localityTextBox;

	@FindBy(css = "#ui-id-1 li:nth-child(2) a")
	private WebElement locationList;

	@FindBy(id = "SearchHotelsButton")
	private WebElement searchButton;

	@FindBy(id = "travellersOnhome")
	private WebElement travellerSelection;

	@FindBy(css = "label[title='Check-in date']")
	private WebElement Check_in;

	@FindBy(css = "div.searchSummary #srpHeaderLabel")
	private WebElement searchSummary;

	public HotelBookingPage() throws Exception {
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

	public String getCurrentUrl(String url) {
		wait.until(ExpectedConditions.urlContains(url));
		return driver.getCurrentUrl();
	}

	public void clickOnHotelsTab() {
		wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(hotelLink));
		hotelLink.click();
	}

	public void enterLocalityInLocalityTextBox(String locality) {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(localityTextBox));
		localityTextBox.sendKeys(locality, Keys.ENTER);
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
		}
	}

	public void selectLocality() {
		locationList.click();
	}

	public void clickOnCheckInTxt() {
		wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(Check_in));
		Check_in.click();
	}

	public void selectTravellersFromTravellersDropDown(String selectionText) {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(travellerSelection));
		new Select(travellerSelection).selectByVisibleText(selectionText);
	}

	public void clickOnSearchHotelsBtton() {
		searchButton.click();
	}

	public boolean checkSearchResult() {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(searchSummary));
		return searchSummary.isDisplayed();
	}

	public void closeSearchHotelsPage() {
		driver.quit();
	}

}
