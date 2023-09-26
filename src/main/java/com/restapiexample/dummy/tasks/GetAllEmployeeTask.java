package com.restapiexample.dummy.tasks;

import com.restapiexample.dummy.utils.Data;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

import java.util.Map;

import static com.restapiexample.dummy.utils.GlobalVariable.idEmployeeCreated;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GetAllEmployeeTask implements Task {
    Map<String, String> data = Data.extractTo().get(0);
    int status = 0;
    @Override
    public <T extends Actor> void performAs(T actor) {
        while (status != 200){
            actor.attemptsTo(
                    Get.resource(data.get("endPointGetAll")).with(
                            requestSpecification -> requestSpecification
                                    .contentType(ContentType.JSON)
                    )
            );

            status = SerenityRest.lastResponse().getStatusCode();
            System.out.println(status);
        }

    }

    public static GetAllEmployeeTask on(){
        return instrumented(GetAllEmployeeTask.class);
    }
}
