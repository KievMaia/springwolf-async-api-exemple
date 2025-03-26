package com.kiev.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.NOT_REQUIRED;
import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

@Schema(description = "Another payload model")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnotherPayloadDto implements Serializable {

    @Schema(description = "Foo field", example = "bar", maxLength = 100, requiredMode = NOT_REQUIRED)
    @JsonProperty("foo")
    private String foo;

    @Schema(description = "Example field", requiredMode = REQUIRED)
    @JsonProperty("exemple")
    private ExamplePayloadDto example;
}