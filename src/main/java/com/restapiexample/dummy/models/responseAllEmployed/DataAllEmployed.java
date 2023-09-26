package com.restapiexample.dummy.models.responseAllEmployed;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DataAllEmployed {

    @JsonProperty("id")
    public Integer id;

    @JsonProperty("employeeName")
    public String employeeName;

    @JsonProperty("employeeSalary")
    public Integer employeeSalary;

    @JsonProperty("employeeAge")
    public Integer employeeAge;

    @JsonProperty("profileImage")
    public String profileImage;
}
