package com.restapiexample.dummy.questions;

import com.restapiexample.dummy.utils.Data;
import com.restapiexample.dummy.models.EmployeeModel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.Map;

public class BuildDataEmployee implements Question<EmployeeModel> {

    Map<String, String> data = Data.extractTo().get(0);
    @Override
    public EmployeeModel answeredBy(Actor actor) {
        return EmployeeModel.builder()
                .name(data.get("name"))
                .salary(data.get("salary"))
                .age(data.get("age"))
                .build();
    }

    public static BuildDataEmployee was(){
        return new BuildDataEmployee();
    }
}
