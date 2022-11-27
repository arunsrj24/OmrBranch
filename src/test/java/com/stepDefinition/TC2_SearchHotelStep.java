package com.stepDefinition;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.base.BaseClass;
import com.pageManager.PageObjectManager;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TC2_SearchHotelStep extends BaseClass{
	
	PageObjectManager pom = new PageObjectManager(); 

	@Then("User search hotel by entering following details {string}, {string}, {string}, {string}, {string}, {string}, {string} and {string}")
	public void user_search_hotel_by_entering_following_details_and(String location, String hotels, String roomtype, String numberofrooms, String checkindate, String checkoutdate, String adultsperroom, String childrenperroom) {
	    pom.getSearchHotelpage().searchHotel(location, hotels, roomtype, numberofrooms, checkindate, checkoutdate, adultsperroom, childrenperroom);
		
	}

	@Then("User should verify after search by success message {string}")
	public void user_should_verify_after_search_by_success_message(String expectedresult) {
	    WebElement successmsg = pom.getSearchHotelpage().getSuccessmsg();
	    String actualresult = successmsg.getText();
	    Assert.assertEquals(actualresult, expectedresult);
	}

	@Then("User search hotel by entering only mandatory fields {string}, {string}, {string}, {string} and {string}")
	public void user_search_hotel_by_entering_only_mandatory_fields_and(String location, String numberofrooms, String checkindate, String checkoutdate, String adultsperroom) {
	    pom.getSearchHotelpage().searchHotel(location, numberofrooms, checkindate, checkoutdate, adultsperroom);
	}

	@Then("User should verify after search by error message {string} and {string}")
	public void user_should_verify_after_search_by_error_message_and(String expected1, String expected2) throws InterruptedException {
		Thread.sleep(2000);
	    String actual1 = pom.getSearchHotelpage().getDateerror1().getText();
	    String actual2 = pom.getSearchHotelpage().getDataerror2().getText();
	    Assert.assertEquals(expected1, actual1);
	    Assert.assertEquals(expected2, actual2);
	}

	@When("User click search button without entering any fields")
	public void user_click_search_button_without_entering_any_fields() {
	   pom.getSearchHotelpage().searchHotel();
	}

	@Then("User verify after search by error message {string}")
	public void user_verify_after_search_by_error_message(String expected) throws InterruptedException {
		Thread.sleep(2000);
	   String actual = pom.getSearchHotelpage().getLocationerror().getText();
	   Assert.assertEquals(expected, actual);
	}


}
