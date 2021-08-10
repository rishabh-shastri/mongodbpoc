package com.eldorado.productservice.stepdefinitions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features={"src/test/resources/features/productDetailsForm.feature","src/test/resources/features/adminOperations.feature","src/test/resources/features/rating.feature","src/test/resources/features/productList.feature"},glue= {"com.eldorado.productservice.stepdefinitions"},
monochrome=true,
plugin = {"pretty","junit:target/junitreports/report.xml",
		  "pretty","html:target/htmlreports/index.html",
		  "pretty","json:target/jsonreports/report.json"
		}
)

public class TestRunner {

}

