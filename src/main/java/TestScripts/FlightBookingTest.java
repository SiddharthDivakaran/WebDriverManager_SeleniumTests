package TestScripts;

import PageObject.FlightBookingPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import Utility.Constants;

public class FlightBookingTest {

	FlightBookingPage flights;

	@BeforeTest
	public void setUp() {
		try {
			flights = new FlightBookingPage();
		} catch (Exception e) {
			e.printStackTrace();
		}
		flights.goTo(Constants.baseUrl);
	}

	@Test
	public void testThatResultsAppearForAOneWayJourney() {

		flights.clickOnOneWayRadioBtn();
		flights.clearFromSearchBox();
		flights.enterLocationInFromSearchBox("Bangalore");
		flights.selectLocationFromSearchBoxSuggestion();
		flights.clearToSearchBox();
		flights.enterLocationInToSearchBox("Delhi");
		flights.selectLocationInToSearchBoxSuggestion();
		flights.clickDepartDate();
		flights.selectDate();
		flights.clickOnSearchBtn();
		Assert.assertEquals(flights.checkSearchResult(), true);

	}

	@AfterTest
	public void tearDown() {
		flights.closeFlightBookingPage();
	}

}
