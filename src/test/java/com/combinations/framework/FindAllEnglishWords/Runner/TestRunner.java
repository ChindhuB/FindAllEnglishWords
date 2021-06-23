package com.combinations.framework.FindAllEnglishWords.Runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(glue={"com.combinations.framework.FindAllEnglishWords.Steps"},features = "src/test/resources/features",monochrome=true,
plugin ={"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","json:target/Report/cucumber.json","pretty:target/Report/pretty.txt",
		"junit:target/Report/cucumber.xml"})
public class TestRunner extends AbstractTestNGCucumberTests {
	@Override
	@DataProvider(parallel =false)
	public Object[][] scenarios() {
		return super.scenarios();
	}
}
