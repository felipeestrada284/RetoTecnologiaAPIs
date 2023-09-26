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
public class DataPost {

    @JsonProperty("name")
    public String name;

    @JsonProperty("salary")
    public String salary;

    @JsonProperty("age")
    public String age;

    @JsonProperty("id")
    public Integer id;
}
