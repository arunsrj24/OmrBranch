package com.report;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.base.BaseClass;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class Reporting extends BaseClass{

	public static void report(String jsonfile) throws IOException {
		
		File file = new File(System.getProperty("user.dir")+getpropertyfilevalue("Jvmpath")); 
		
		Configuration config = new Configuration(file, "Adactin Report");
		
		config.addClassifications("BrowserName", "Egde");
		config.addClassifications("BrowserVersion", "105");
		
		ArrayList<String> json = new ArrayList<String>();
		json.add(jsonfile);
		
		ReportBuilder build = new ReportBuilder(json, config);
		
		build.generateReports();		
		
	}
}
