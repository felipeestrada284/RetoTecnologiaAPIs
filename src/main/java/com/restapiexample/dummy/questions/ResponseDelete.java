package com.restapiexample.dummy.questions;

import com.restapiexample.dummy.models.responseDelete.ResponseEmployeeDelete;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ResponseDelete implements Question<ResponseEmployeeDelete> {
    @Override
    public ResponseEmployeeDelete answeredBy(Actor actor) {
        return SerenityRest.lastResponse().as(ResponseEmployeeDelete.class);
    }

    public static ResponseDelete was(){
        return new ResponseDelete();
    }
}
