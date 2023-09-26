package com.restapiexample.dummy.questions;

import com.restapiexample.dummy.models.EmployeeModel;
import com.restapiexample.dummy.utils.Data;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.Map;

public class UpdateDataEmployee implements Question<EmployeeModel> {

    Map<String, String> data = Data.extractTo().get(0);
    @Override
    public EmployeeModel answeredBy(Actor actor) {
        return EmployeeModel.builder()
                .name(data.get("nameUpdate"))
                .salary(data.get("salaryUpdate"))
                .age(data.get("ageUpdate"))
                .build();
    }

    public static UpdateDataEmployee was(){
        return new UpdateDataEmployee();
    }
}
