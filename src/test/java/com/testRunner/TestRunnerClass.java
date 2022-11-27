package com.testRunner;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.base.BaseClass;
import com.report.Reporting;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources",
glue="com.stepDefinition",dryRun=false,
monochrome=true,tags="@login",
plugin="json:C:\\Users\\Arunsrj\\eclipse-workspace\\OmrBranchAdactinAutomation\\target\\out.json"
)
 
public class TestRunnerClass extends BaseClass{
	

	@AfterClass
	public static void afterclass() throws IOException {
		
		Reporting.report(System.getProperty("user.dir")+getpropertyfilevalue("jsonpath"));
	}
	
}
