package com.restapiexample.dummy.stepDefinitions;

import com.restapiexample.dummy.tasks.PostCreateEmployeeTask;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;

public class GetEmployeeStepDef {
    private EnvironmentVariables environmentVariables;
    Actor user = Actor.named("user");

    @Before
    public void setUpBaseUrl(){
        String theRestApiBaseUrl = environmentVariables.optionalProperty("restapi.baseurl")
                .orElse("https://dummy.restapiexample.com/api/v1");

        user.whoCan(CallAnApi.at(theRestApiBaseUrl));

    }

    @When("I consume the service and I send employee information")
    public void iConsumeTheServiceAndISendEmployeeInformation() {
        user.attemptsTo(PostCreateEmployeeTask.on());
    }
    @Then("I can validate the service response message")
    public void iCanValidateTheServiceResponseMessage() {
    }

}
