package com.stepDefinition;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.WebElement;
import com.base.BaseClass;
import com.pageManager.PageObjectManager;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class TC1_LoginStep extends BaseClass{

	PageObjectManager pom = new PageObjectManager();
	
	@Given("User should navigate to the Adactin login page using url")
	public void user_should_navigate_to_the_Adactin_login_page_using_url() throws IOException {

	}

	@When("User should login by entering {string}, {string}")
	public void user_should_login_by_entering(String username, String password) {
	   pom.getLoginpage().login(username, password);
	}

	@And("User should login by entering {string}, {string} by Enter Key")
	public void user_should_login_by_entering_by_Enter_Key(String username, String password) throws AWTException {
	    pom.getLoginpage().loginwithenterkey(username, password);
	}

	@Then("User should verify unsuccessful login with message contains {string}")
	public void user_should_verify_unsuccessful_login_with_message_contains(String expectedMessage) {
	   WebElement actual = pom.getLoginpage().getTexterrorlogin();
	   String actualmessage = actual.getText();
	   boolean contains = actualmessage.contains(expectedMessage);
	   System.out.println(actualmessage);
	   Assert.assertTrue("Verify after login message",contains);
	}

}
