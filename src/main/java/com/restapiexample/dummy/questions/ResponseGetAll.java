package com.restapiexample.dummy.questions;

import com.restapiexample.dummy.models.responseAllEmployed.ResponseAllEmployeeGet;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ResponseGetAll implements Question<ResponseAllEmployeeGet> {
    @Override
    public ResponseAllEmployeeGet answeredBy(Actor actor) {
        return SerenityRest.lastResponse().as(ResponseAllEmployeeGet.class);
    }

    public static ResponseGetAll was(){
        return new ResponseGetAll();
    }
}
