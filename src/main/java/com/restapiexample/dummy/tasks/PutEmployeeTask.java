package com.restapiexample.dummy.tasks;

import com.restapiexample.dummy.models.EmployeeModel;
import com.restapiexample.dummy.questions.ResponsePost;
import com.restapiexample.dummy.questions.UpdateDataEmployee;
import com.restapiexample.dummy.utils.Data;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;
import net.serenitybdd.screenplay.rest.interactions.Put;

import java.util.Map;

import static com.restapiexample.dummy.utils.GlobalVariable.idEmployeeCreated;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class PutEmployeeTask implements Task {
    Map<String, String> data = Data.extractTo().get(0);
    int status = 0;
    @Override
    public <T extends Actor> void performAs(T actor) {
        EmployeeModel employeeModel = actor.asksFor(UpdateDataEmployee.was());

        while (status != 200){
            actor.attemptsTo(
                    Put.to(data.get("endPointPut")+idEmployeeCreated).with(
                            requestSpecification -> requestSpecification
                                    .contentType(ContentType.JSON)
                                    .body(employeeModel)
                                    //.log().all()
                    )
            );

            status = SerenityRest.lastResponse().getStatusCode();
            System.out.println(status);
        }

        System.out.println(ResponsePost.was().answeredBy(actor).message);

    }

    public static PutEmployeeTask on(){
        return instrumented(PutEmployeeTask.class);
    }
}
