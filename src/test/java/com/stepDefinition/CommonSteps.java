package com.stepDefinition;

import org.openqa.selenium.WebElement;

import com.base.BaseClass;
import com.pageManager.PageObjectManager;

import cucumber.api.java.en.Then;
import junit.framework.Assert;

public class CommonSteps extends BaseClass{
	PageObjectManager pom = new PageObjectManager();

	@Then("User should verify successful login with message {string}")
	public void user_should_verify_successful_login_with_message(String expectedsuccess) {
	    
		WebElement textsuccess = pom.getLoginpage().getTextsuccess();
		String actualsuccess = textsuccess.getAttribute("value");
		System.out.println("Success Login");
		System.out.println(actualsuccess);
		Assert.assertEquals(expectedsuccess, actualsuccess);
	}
}
