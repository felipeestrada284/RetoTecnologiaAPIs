package com.restapiexample.dummy.models.responsePost;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseEmployeePost {

    @JsonProperty("status")
    public String status;

    @JsonProperty("data")
    public DataPost data;

    @JsonProperty("message")
    public String message;
}
