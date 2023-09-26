package com.restapiexample.dummy.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeModel {

    @JsonProperty("name")
    public String name;

    @JsonProperty("salary")
    public String salary;

    @JsonProperty("age")
    public String age;
}
