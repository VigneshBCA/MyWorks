package com.Runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;



@RunWith(Cucumber.class)
@CucumberOptions(features= "src/test/resources/Features",
glue="com.cucumber.Step_definition",
dryRun = false,
monochrome = true,
plugin="json:reports/cucumberReport.json"
)
public class Runner_class {



}
