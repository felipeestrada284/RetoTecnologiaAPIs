package com.restapiexample.dummy.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/employee.feature",
        glue = "com.restapiexample.dummy.stepDefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        tags = "@Post"
)
public class EmployeeRunner {
}
