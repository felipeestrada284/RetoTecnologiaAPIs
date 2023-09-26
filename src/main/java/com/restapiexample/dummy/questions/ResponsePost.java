package com.restapiexample.dummy.questions;

import com.restapiexample.dummy.models.responsePost.ResponseEmployeePost;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ResponsePost implements Question<ResponseEmployeePost> {
    @Override
    public ResponseEmployeePost answeredBy(Actor actor) {
        return SerenityRest.lastResponse().as(ResponseEmployeePost.class);
    }

    public static ResponsePost was(){
        return new ResponsePost();
    }
}
