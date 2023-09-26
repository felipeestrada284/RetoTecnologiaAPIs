package com.restapiexample.dummy.tasks;

import com.restapiexample.dummy.models.EmployeeModel;
import com.restapiexample.dummy.questions.BuildDataEmployee;
import com.restapiexample.dummy.questions.ResponsePost;
import com.restapiexample.dummy.utils.Data;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;

import java.util.Map;

import static com.restapiexample.dummy.utils.GlobalVariable.idEmployeeCreated;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class PostCreateEmployeeTask implements Task {
    Map<String, String> data = Data.extractTo().get(0);

    @Override
    public <T extends Actor> void performAs(T actor) {
        EmployeeModel employeeModel = actor.asksFor(BuildDataEmployee.was());
        actor.attemptsTo(
                Post.to(data.get("endPointPost")).with(
                        requestSpecification -> requestSpecification
                                .contentType(ContentType.JSON)
                                .body(employeeModel) .log().all()
                )
        );

        System.out.println(ResponsePost.was().answeredBy(actor).message);

        idEmployeeCreated = ResponsePost.was().answeredBy(actor).getData().id;
        System.out.println("id created: "+ idEmployeeCreated);
    }

    public static PostCreateEmployeeTask on(){
        return instrumented(PostCreateEmployeeTask.class);
    }
}
