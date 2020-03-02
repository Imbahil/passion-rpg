package com.duboiscave.passion.rpg.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Setter
@FieldNameConstants
@AllArgsConstructor
public class PropertyDto {

    @NotNull
    private UUID propertyUuid;
}
