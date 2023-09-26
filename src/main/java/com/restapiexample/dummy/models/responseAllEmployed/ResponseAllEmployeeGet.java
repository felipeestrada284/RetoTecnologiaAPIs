package com.restapiexample.dummy.models.responseAllEmployed;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseAllEmployeeGet {

    @JsonProperty("status")
    public String status;

    @JsonProperty("data")
    public List<DataAllEmployed> data;

    @JsonProperty("message")
    public String message;
}
