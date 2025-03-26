package com.kiev.dtos;

import com.kiev.enums.ExampleEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

@Schema(description = "Example payload model")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExamplePayloadDto implements Serializable {
    @Schema(description = "Some string field", example = "some string value", requiredMode = REQUIRED)
    private String someString;

    @Schema(description = "Some long field", example = "5", minimum = "0")
    private long someLong;

    @Schema(description = "Some enum field", example = "FOO2", requiredMode = REQUIRED)
    private ExampleEnum someEnum;
}