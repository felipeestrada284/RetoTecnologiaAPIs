package com.restapiexample.dummy.stepDefinitions;

import com.restapiexample.dummy.questions.ResponsePost;
import com.restapiexample.dummy.questions.ServerCodeResponse;
import com.restapiexample.dummy.tasks.GetEmployeeTask;
import com.restapiexample.dummy.tasks.PostCreateEmployeeTask;
import com.restapiexample.dummy.utils.Data;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;

import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class GetEmployeeStepDef {
    private EnvironmentVariables environmentVariables;
    Actor user = Actor.named("user");

    @Before
    public void setUpBaseUrl(){
        String theRestApiBaseUrl = environmentVariables.optionalProperty("restapi.baseurl")
                .orElse("https://dummy.restapiexample.com/api/v1");

        user.whoCan(CallAnApi.at(theRestApiBaseUrl));

    }

    @When("I consume the service and send employee id")
    public void iConsumeTheServiceAndSendEmployeeId() {
        user.attemptsTo(GetEmployeeTask.on());
    }

    @Then("I can validate the service response get")
    public void iCanValidateTheServiceResponseGet() {
        Map<String, String> data = Data.extractTo().get(0);

        user.should(
                seeThat(
                        "The response code was: ",
                        ServerCodeResponse.was(),
                        equalTo(data.get("status"))
                )
        );
    }


}
