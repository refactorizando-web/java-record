package com.refactorizando.example.record.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record CarDto(@JsonProperty("id") Long id, @JsonProperty("brand") BrandDto brandDto, @JsonProperty("model") String mode,
                     @JsonProperty("color") String color) {

}
