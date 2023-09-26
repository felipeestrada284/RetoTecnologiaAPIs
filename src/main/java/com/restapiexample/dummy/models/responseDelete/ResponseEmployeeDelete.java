package com.restapiexample.dummy.models.responseDelete;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.restapiexample.dummy.models.responsePost.DataPost;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseEmployeeDelete {
    @JsonProperty("status")
    public String status;

    @JsonProperty("data")
    public DataPost data;

    @JsonProperty("message")
    public String message;
}
