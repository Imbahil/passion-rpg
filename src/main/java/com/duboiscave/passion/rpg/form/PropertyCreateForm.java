package com.duboiscave.passion.rpg.form;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldNameConstants
public class PropertyCreateForm {

    @NotBlank
    @Length(min = 1, max = 10)
    private String propertyCode;

    @NotNull
    private Boolean leased;

    @NotNull
    @Length(min = 1, max = 255)
    private String address; //todo wyniesc do osobnego obiektu

    @NotNull
    private Integer numberOfApartments;
}
