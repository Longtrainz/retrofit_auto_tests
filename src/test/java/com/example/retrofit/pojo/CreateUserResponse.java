package com.example.retrofit.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@ToString
@Accessors(fluent = true)
public class CreateUserResponse {

    @JsonProperty("createdAt")
    private String createdAt;

    @JsonProperty("id")
    private String id;
    @JsonProperty("job")
    private String job;

    @JsonProperty("name")
    private String name;
}
