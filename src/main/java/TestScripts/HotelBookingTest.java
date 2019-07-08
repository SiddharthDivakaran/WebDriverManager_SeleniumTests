package TestScripts;

import PageObject.HotelBookingPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import Utility.Constants;

public class HotelBookingTest {

	HotelBookingPage hotels;

	@BeforeTest
	public void setUp() {
		try {
			hotels = new HotelBookingPage();
		} catch (Exception e) {
			e.printStackTrace();
		}
		hotels.goTo(Constants.baseUrl);
	}

	@Test
	public void shouldBeAbleToSearchForHotels() {

		hotels.clickOnHotelsTab();
		Assert.assertTrue(hotels.getCurrentUrl("hotels").contains("hotels"));
		hotels.enterLocalityInLocalityTextBox("Indiranagar, Bangalore");
		hotels.selectLocality();
		hotels.clickOnCheckInTxt();
		hotels.selectTravellersFromTravellersDropDown("1 room, 2 adults");
		hotels.clickOnSearchHotelsBtton();
		Assert.assertEquals(hotels.checkSearchResult(), true);
	}

	@AfterTest
	public void tearDown() {
		hotels.closeSearchHotelsPage();
	}

}
