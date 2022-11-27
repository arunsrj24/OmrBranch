package com.stepDefinition;

import org.junit.Assert;

import com.base.BaseClass;
import com.pageManager.PageObjectManager;

import cucumber.api.java.en.Then;

public class TC3_SelectHotelStep extends BaseClass{
	
	PageObjectManager pom = new PageObjectManager();

	@Then("User should select Hotel name")
	public void user_should_select_Hotel_name() {
	   pom.getSelectHotelpage().selectHotel();
	}

	@Then("User should verify after select Hotel with success message {string}")
	public void user_should_verify_after_select_Hotel_with_success_message(String expected) throws InterruptedException {
		Thread.sleep(2000);
	    String actual = pom.getSelectHotelpage().getSuccessmsg().getText();
	    Assert.assertEquals(expected, actual);
	}

	@Then("User should click continue without select hotel name")
	public void user_should_click_continue_without_select_hotel_name() {
	   pom.getSelectHotelpage().clickContinue();
	}

	@Then("User should verify after select Hotel with error message {string}")
	public void user_should_verify_after_select_Hotel_with_error_message(String expected) throws InterruptedException {
		Thread.sleep(2000);
	   String actual = pom.getSelectHotelpage().getErrormsg().getText();
	   Assert.assertEquals(expected, actual);
	} 


}
