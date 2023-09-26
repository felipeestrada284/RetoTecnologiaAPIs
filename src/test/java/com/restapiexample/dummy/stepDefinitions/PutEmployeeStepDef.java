package com.restapiexample.dummy.stepDefinitions;

import com.restapiexample.dummy.questions.ResponsePost;
import com.restapiexample.dummy.questions.ServerCodeResponse;
import com.restapiexample.dummy.tasks.PostCreateEmployeeTask;
import com.restapiexample.dummy.tasks.PutEmployeeTask;
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

public class PutEmployeeStepDef {
    private EnvironmentVariables environmentVariables;
    Actor user = Actor.named("user");

    @Before
    public void setUpBaseUrl(){
        String theRestApiBaseUrl = environmentVariables.optionalProperty("restapi.baseurl")
                .orElse("https://dummy.restapiexample.com/api/v1");

        user.whoCan(CallAnApi.at(theRestApiBaseUrl));

    }

    @When("I consume the service and send the employee information and the id")
    public void iConsumeTheServiceAndSendTheEmployeeInformationAndTheId() {
        user.attemptsTo(PutEmployeeTask.on());
    }

    @Then("I can validate the service response put")
    public void iCanValidateTheServiceResponsePut() {
        Map<String, String> data = Data.extractTo().get(0);

        user.should(
                seeThat(
                        "The response code was: ",
                        ServerCodeResponse.was(),
                        equalTo(Integer.parseInt(data.get("status")))
                )
        );
    }


}
