package com.stepDefinition;


import java.io.IOException;
import com.base.BaseClass;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class HooksClass extends BaseClass{

	@Before
	public void beforescenario() throws IOException {
		crossBrowser(getpropertyfilevalue("Browsername"));
		urlonly(getpropertyfilevalue("Url"));

	}
	
	@After
	public void afterscenario(Scenario scenario){
		
		scenario.embed(screenshot(), "image/png");
		
		
		close();

	}
}
